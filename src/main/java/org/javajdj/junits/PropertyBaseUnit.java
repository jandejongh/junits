/* 
 * Copyright 2010-2020 Jan de Jongh <jfcmdejongh@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package org.javajdj.junits;

/** A physical (scalar) property with its/a base {@link Unit} (typically SI).
 *
 * <p>
 * This {@link Enum} class contains the most important system or material properties (in electrical engineering),
 * each associated with a {@link Unit}.
 * Unlike {@link Unit}, this class is only occupied with distinguishing between physical properties,
 * and not so much with their representations.
 * With each property, a single {@link Unit} is associated that acts as an anchor point for
 * conversions between various {@link Unit}s representations.
 * 
 * <p>
 * This class restricts itself to <i>basic</i> properties, but not just to the SI base quantities.
 * For instance, it also contains properties like inductance, capacitance, and frequency,
 * all of which are "derived" properties from the SI base quantities.
 * 
 * <p>
 * Finally, this class contains conversion methods between compatible (e.g., time/frequency) properties.
 * 
 * @see Unit
 * 
 * @author Jan de Jongh {@literal <jfcmdejongh@gmail.com>}
 * 
 */
public enum PropertyBaseUnit
{
  
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  //
  // ENUM VALUES
  //
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  PROPERTY_NONE        (Unit.UNIT_NONE),
  PROPERTY_VOLTAGE     (Unit.UNIT_V),
  PROPERTY_CURRENT     (Unit.UNIT_A),
  PROPERTY_RESISTANCE  (Unit.UNIT_Ohm),
  PROPERTY_POWER       (Unit.UNIT_W),
  PROPERTY_TIME        (Unit.UNIT_s),
  PROPERTY_FREQUENCY   (Unit.UNIT_Hz),
  PROPERTY_CAPACITANCE (Unit.UNIT_F),
  PROPERTY_INDUCTANCE  (Unit.UNIT_H),
  PROPERTY_TEMPERATURE (Unit.UNIT_K),
  PROPERTY_ENERGY      (Unit.UNIT_J),
  PROPERTY_DISTANCE    (Unit.UNIT_m),
  PROPERTY_VELOCITY    (Unit.UNIT_mps);
  
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  //
  // CONSTRUCTOR(S) / FACTORY / CLONING
  //
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  PropertyBaseUnit (final Unit siUnit)
  {
    this.siUnit = siUnit;
  }
  
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  //
  // SI UNIT
  //
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  private final Unit siUnit;
  
  /** Returns the base (SI) unit of this (physical) property.
   * 
   * @return The SI unit.
   * 
   * @see Unit
   * 
   */
  public final Unit getSiUnit ()
  {
    return this.siUnit;
  }
  
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  //
  // NAME / toString
  //
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
  @Override
  public String toString ()
  {
    return this.siUnit.toString ();
  }
  
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  //
  // QUANTITY/UNIT CONVERSION
  //
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
  /** Checks whether two given (base) units are compatible in the sense that one can be converted into the other, and vice versa.
   * 
   * @param pbu1 A property base unit.
   * @param pbu2 Another property base unit.
   * 
   * @return True if both properties are non-{@code null} and are compatible, i.e., are equal or allow conversions both ways.
   * 
   * @throws IllegalArgumentException If either argument is {@code null}.
   * 
   * @see #convert
   * 
   */ 
  public static final boolean canConvert (final PropertyBaseUnit pbu1, final PropertyBaseUnit pbu2)
  {
    if (pbu1 == null || pbu2 == null)
      throw new IllegalArgumentException ();
    if (pbu1 == pbu2)
      return true;
    switch (pbu1)
    {
      case PROPERTY_NONE:
        return false;
      case PROPERTY_VOLTAGE:
        return false;
      case PROPERTY_CURRENT:
        return false;
      case PROPERTY_RESISTANCE:
        return false;
      case PROPERTY_POWER:
        return false;
      case PROPERTY_TIME:
        return pbu2 == PROPERTY_FREQUENCY;
      case PROPERTY_FREQUENCY:
        return pbu2 == PROPERTY_TIME;
      case PROPERTY_CAPACITANCE:
        return false;
      case PROPERTY_INDUCTANCE:
        return false;
      case PROPERTY_TEMPERATURE:
        return false;
      case PROPERTY_ENERGY:
        return false;
      case PROPERTY_DISTANCE:
        return false;
      case PROPERTY_VELOCITY:
        return false;
      default:
        throw new RuntimeException ();
    }
  }
  
  /** Converts physical quantities between two given base units.
   * 
   * @param magnitude The magnitude of the property.
   * @param fromPBU   The unit against which the input property is represented.
   * @param toPBU     The (base) unit to convert to.
   * 
   * @return The converted magnitude in the target unit.
   * 
   * @throws IllegalArgumentException If either unit argument is {@code null}, or conversion between the units is impossible.
   * 
   */
  public static final double convert (final double magnitude, final PropertyBaseUnit fromPBU, final PropertyBaseUnit toPBU)
  {
    if (fromPBU == null || toPBU == null)
      throw new IllegalArgumentException ();
    if (fromPBU == toPBU)
      return magnitude;
    switch (fromPBU)
    {
      case PROPERTY_NONE:
      case PROPERTY_VOLTAGE:
      case PROPERTY_CURRENT:
      case PROPERTY_RESISTANCE:
      case PROPERTY_POWER:
        throw new IllegalArgumentException ();
      case PROPERTY_TIME:
        if (toPBU != PROPERTY_FREQUENCY)
          throw new IllegalArgumentException ();
        return 1 / magnitude; 
      case PROPERTY_FREQUENCY:
        if (toPBU != PROPERTY_TIME)
          throw new IllegalArgumentException ();
        return 1 / magnitude;
      case PROPERTY_CAPACITANCE:
      case PROPERTY_INDUCTANCE:
      case PROPERTY_TEMPERATURE:
      case PROPERTY_ENERGY:
      case PROPERTY_DISTANCE:
      case PROPERTY_VELOCITY:
        throw new IllegalArgumentException ();
      default:
        throw new RuntimeException ();
    }
  }
  
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  //
  // END OF FILE
  //
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
}
