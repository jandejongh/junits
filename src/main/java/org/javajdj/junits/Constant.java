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

/** A physical or mathematical constant.
 *
 * @author Jan de Jongh {@literal <jfcmdejongh@gmail.com>}
 *
 * @see Unit
 * 
 */
public final class Constant
  extends PhysicalValue
{
  
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  //
  // CONSTRUCTOR(S) / FACTORY / CLONING
  //
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  private Constant (final double value, final Unit unit)
  {
    super (value, unit);
  }
  
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  //
  // SPEED/VELOCITY OF LIGHT
  //
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  /** The velocity/speed of light in meters per second.
   * 
   * @see Unit#UNIT_mps
   * 
   */
  public final static Constant C_MPS = new Constant (299792458, Unit.UNIT_mps);
    
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  //
  // TEMPERATURE
  //
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  /** The temperature of zero degrees Celsius expressed in Kelvin.
   * 
   * @see Unit#UNIT_C
   * @see Unit#UNIT_K
   * 
   */
  public final static Constant ZERO_CELSIUS_K = new Constant (273.15, Unit.UNIT_K);
  
  /** The temperature of zero Kelvin expressed in degrees Celsius.
   * 
   * @see Unit#UNIT_K
   * @see Unit#UNIT_C
   * 
   */
  public final static Constant ZERO_K_CELSIUS = new Constant (-273.15, Unit.UNIT_C);
  
  /** The temperature of zero degrees Fahrenheit expressed in Kelvin.
   * 
   * @see Unit#UNIT_degreesF
   * @see Unit#UNIT_K
   * 
   */
  public final static Constant ZERO_FAHRENHEIT_K = new Constant (459.67 * 5 / 9, Unit.UNIT_K);

  /** The temperature of zero Kelvin expressed in degrees Fahrenheit.
   * 
   * @see Unit#UNIT_K
   * @see Unit#UNIT_degreesF
   * 
   */
  public final static Constant ZERO_K_FAHRENHEIT = new Constant (-459.67, Unit.UNIT_degreesF);

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  //
  // END OF FILE
  //
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
}
