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

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Function;

/** A physical (scalar) unit.
 *
 * <p>
 * This {@link Enum} class contains (or aims to) the most important
 * physical unit used in electrical engineering.
 * For practical reasons, it includes multiple units for a "basic property",
 * like {@link Unit#UNIT_A} and {@link Unit#UNIT_mA} for the basic property "current",
 * i.e., for {@link PropertyBaseUnit#PROPERTY_CURRENT}.
 * Hence, for a more fundamental picture, refer to {@link PropertyBaseUnit}.
 * 
 * @see PropertyBaseUnit
 * 
 * @author Jan de Jongh {@literal <jfcmdejongh@gmail.com>}
 * 
 */
public enum Unit
{
  
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  //
  // ENUM VALUES
  //
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  //
  // DIMENSIONLESS
  //
  
  UNIT_NONE (PropertyBaseUnit.PROPERTY_NONE, 1, ""),
  
  //
  // VOLTAGE
  //
  UNIT_pV  (PropertyBaseUnit.PROPERTY_VOLTAGE, 1E-12, "pV"),
  UNIT_nV  (PropertyBaseUnit.PROPERTY_VOLTAGE, 1E-9 , "nV"),
  UNIT_muV (PropertyBaseUnit.PROPERTY_VOLTAGE, 1E-6 , "\u03BCV"),
  UNIT_mV  (PropertyBaseUnit.PROPERTY_VOLTAGE, 1E-3 , "mV"),
  UNIT_V   (PropertyBaseUnit.PROPERTY_VOLTAGE, 1    , "V"),
  UNIT_kV  (PropertyBaseUnit.PROPERTY_VOLTAGE, 1E3  , "kV"),
  
  //
  // CURRENT
  //
  UNIT_pA  (PropertyBaseUnit.PROPERTY_CURRENT, 1E-12, "pA"),
  UNIT_nA  (PropertyBaseUnit.PROPERTY_CURRENT, 1E-9 , "nA"),
  UNIT_muA (PropertyBaseUnit.PROPERTY_CURRENT, 1E-6 , "\u03BCA"),
  UNIT_mA  (PropertyBaseUnit.PROPERTY_CURRENT, 1E-3 , "mA"),
  UNIT_A   (PropertyBaseUnit.PROPERTY_CURRENT, 1    , "A"),
  UNIT_kA  (PropertyBaseUnit.PROPERTY_CURRENT, 1E3  , "kA"),
  
  //
  // RESISTANCE / IMPEDANCE
  //
  UNIT_muOhm (PropertyBaseUnit.PROPERTY_RESISTANCE, 1E-6, "\u03BC\u03A9"),
  UNIT_mOhm  (PropertyBaseUnit.PROPERTY_RESISTANCE, 1E-3, "m\u03A9"),
  UNIT_Ohm   (PropertyBaseUnit.PROPERTY_RESISTANCE, 1   , "\u03A9"),
  UNIT_kOhm  (PropertyBaseUnit.PROPERTY_RESISTANCE, 1E3 , "k\u03A9"),
  UNIT_MOhm  (PropertyBaseUnit.PROPERTY_RESISTANCE, 1E6 , "M\u03A9"),
  UNIT_GOhm  (PropertyBaseUnit.PROPERTY_RESISTANCE, 1E9 , "G\u03A9"),
  
  //
  // POWER
  //
  UNIT_aW  (PropertyBaseUnit.PROPERTY_POWER, 1E-18, "aW"),
  UNIT_fW  (PropertyBaseUnit.PROPERTY_POWER, 1E-15, "fW"),
  UNIT_pW  (PropertyBaseUnit.PROPERTY_POWER, 1E-12, "pW"),
  UNIT_nW  (PropertyBaseUnit.PROPERTY_POWER, 1E-9 , "nW"),
  UNIT_muW (PropertyBaseUnit.PROPERTY_POWER, 1E-6 , "\u03BCW"),
  UNIT_mW  (PropertyBaseUnit.PROPERTY_POWER, 1E-3 , "mW"),
  UNIT_W   (PropertyBaseUnit.PROPERTY_POWER, 1    , "W"),
  UNIT_kW  (PropertyBaseUnit.PROPERTY_POWER, 1E3  , "kW"),
  UNIT_dBm (PropertyBaseUnit.PROPERTY_POWER, (d) -> 1E-3  * Math.pow (10, d / 10), (d) -> 10 * Math.log10 (d * 1E3), "dBm"),
  
  //
  // TIME [INTERVAL] / DURATION
  //
  UNIT_ps  (PropertyBaseUnit.PROPERTY_TIME, 1E-12, "ps"),
  UNIT_ns  (PropertyBaseUnit.PROPERTY_TIME, 1E-9 , "ns"),
  UNIT_mus (PropertyBaseUnit.PROPERTY_TIME, 1E-6 , "\u03BCs"),
  UNIT_ms  (PropertyBaseUnit.PROPERTY_TIME, 1E-3 , "ms"),
  UNIT_s   (PropertyBaseUnit.PROPERTY_TIME, 1    , "s"),
  UNIT_ks  (PropertyBaseUnit.PROPERTY_TIME, 1E3  , "ks"),
  UNIT_Ms  (PropertyBaseUnit.PROPERTY_TIME, 1E6  , "Ms"),
  UNIT_Gs  (PropertyBaseUnit.PROPERTY_TIME, 1E9  , "Gs"),
  
  //
  // FREQUENCY
  //
  UNIT_muHz (PropertyBaseUnit.PROPERTY_FREQUENCY, 1E-6, "\u03BCHz"),
  UNIT_mHz  (PropertyBaseUnit.PROPERTY_FREQUENCY, 1E-3, "mHz"),
  UNIT_Hz   (PropertyBaseUnit.PROPERTY_FREQUENCY, 1   , "Hz"),
  UNIT_kHz  (PropertyBaseUnit.PROPERTY_FREQUENCY, 1E3 , "kHz"),
  UNIT_MHz  (PropertyBaseUnit.PROPERTY_FREQUENCY, 1E6 , "MHz"),
  UNIT_GHz  (PropertyBaseUnit.PROPERTY_FREQUENCY, 1E9 , "GHz"),
  UNIT_THz  (PropertyBaseUnit.PROPERTY_FREQUENCY, 1E12, "THz"),
  
  //
  // CAPACITANCE
  //
  UNIT_pF  (PropertyBaseUnit.PROPERTY_CAPACITANCE, 1E-12,"pF"),
  UNIT_nF  (PropertyBaseUnit.PROPERTY_CAPACITANCE, 1E-9, "nF"),
  UNIT_muF (PropertyBaseUnit.PROPERTY_CAPACITANCE, 1E-6, "\u03BCF"),
  UNIT_mF  (PropertyBaseUnit.PROPERTY_CAPACITANCE, 1E-3, "mF"),
  UNIT_F   (PropertyBaseUnit.PROPERTY_CAPACITANCE, 1   , "F"),
  UNIT_kF  (PropertyBaseUnit.PROPERTY_CAPACITANCE, 1E3 , "kF"),
  UNIT_MF  (PropertyBaseUnit.PROPERTY_CAPACITANCE, 1E6 , "MF"),
  
  //
  // INDUCTANCE
  //
  UNIT_pH  (PropertyBaseUnit.PROPERTY_INDUCTANCE, 1E-12,"pH"),
  UNIT_nH  (PropertyBaseUnit.PROPERTY_INDUCTANCE, 1E-9, "nH"),
  UNIT_muH (PropertyBaseUnit.PROPERTY_INDUCTANCE, 1E-6, "\u03BCH"),
  UNIT_mH  (PropertyBaseUnit.PROPERTY_INDUCTANCE, 1E-3, "mH"),
  UNIT_H   (PropertyBaseUnit.PROPERTY_INDUCTANCE, 1   , "H"),
  UNIT_kH  (PropertyBaseUnit.PROPERTY_INDUCTANCE, 1E3 , "kH"),
  UNIT_MH  (PropertyBaseUnit.PROPERTY_INDUCTANCE, 1E6 , "MH"),
  
  //
  // TEMPERATURE
  //
  UNIT_K (PropertyBaseUnit.PROPERTY_TEMPERATURE, 1, "K"),
  UNIT_C (PropertyBaseUnit.PROPERTY_TEMPERATURE,
    (c) -> c + Constant.ZERO_CELSIUS_K.getValue (),
    (k) -> k - Constant.ZERO_CELSIUS_K.getValue (),
    "C"),
  // XXX NEED Fahrenheit!
  
  //
  // ENERGY
  //
  UNIT_aJ  (PropertyBaseUnit.PROPERTY_ENERGY, 1E-18, "aJ"),
  UNIT_fJ  (PropertyBaseUnit.PROPERTY_ENERGY, 1E-15, "fJ"),
  UNIT_pJ  (PropertyBaseUnit.PROPERTY_ENERGY, 1E-12, "pJ"),
  UNIT_nJ  (PropertyBaseUnit.PROPERTY_ENERGY, 1E-9,  "nJ"),
  UNIT_muJ (PropertyBaseUnit.PROPERTY_ENERGY, 1E-6,  "\u03BCJ"),
  UNIT_mJ  (PropertyBaseUnit.PROPERTY_ENERGY, 1E-3,  "mJ"),
  UNIT_J   (PropertyBaseUnit.PROPERTY_ENERGY, 1,     "J"),
  UNIT_kJ  (PropertyBaseUnit.PROPERTY_ENERGY, 1E3,   "kJ"),
  UNIT_MJ  (PropertyBaseUnit.PROPERTY_ENERGY, 1E6,   "MJ"),
  UNIT_GJ  (PropertyBaseUnit.PROPERTY_ENERGY, 1E9,   "GJ"),
  UNIT_TJ  (PropertyBaseUnit.PROPERTY_ENERGY, 1E12,  "TJ"),
  UNIT_PJ  (PropertyBaseUnit.PROPERTY_ENERGY, 1E15,  "PJ"),
  UNIT_EJ  (PropertyBaseUnit.PROPERTY_ENERGY, 1E18,  "EJ"),
  
  //
  // DISTANCE
  //
  UNIT_am  (PropertyBaseUnit.PROPERTY_DISTANCE, 1E-18, "am"),
  UNIT_fm  (PropertyBaseUnit.PROPERTY_DISTANCE, 1E-15, "fm"),
  UNIT_pm  (PropertyBaseUnit.PROPERTY_DISTANCE, 1E-12, "pm"),
  UNIT_nm  (PropertyBaseUnit.PROPERTY_DISTANCE, 1E-9,  "nm"),
  UNIT_mum (PropertyBaseUnit.PROPERTY_DISTANCE, 1E-6,  "\u03BCm"),
  UNIT_mm  (PropertyBaseUnit.PROPERTY_DISTANCE, 1E-3,  "mm"),
  UNIT_cm  (PropertyBaseUnit.PROPERTY_DISTANCE, 1E-2,  "cm"),
  UNIT_dm  (PropertyBaseUnit.PROPERTY_DISTANCE, 1E-1,  "dm"),
  UNIT_m   (PropertyBaseUnit.PROPERTY_DISTANCE, 1,     "m"),
  UNIT_dam (PropertyBaseUnit.PROPERTY_DISTANCE, 1E1,   "dam"),
  UNIT_hm  (PropertyBaseUnit.PROPERTY_DISTANCE, 1E2,   "hm"),
  UNIT_km  (PropertyBaseUnit.PROPERTY_DISTANCE, 1E3,   "km"),
  UNIT_Mm  (PropertyBaseUnit.PROPERTY_DISTANCE, 1E6,   "Mm"),
  UNIT_Gm  (PropertyBaseUnit.PROPERTY_DISTANCE, 1E9,   "Gm"),
  UNIT_Tm  (PropertyBaseUnit.PROPERTY_DISTANCE, 1E12,  "Tm"),
  UNIT_Pm  (PropertyBaseUnit.PROPERTY_DISTANCE, 1E15,  "Pm"),
  UNIT_Em  (PropertyBaseUnit.PROPERTY_DISTANCE, 1E18,  "Em"),
  
  //
  // VELOCITY
  //
  UNIT_amps  (PropertyBaseUnit.PROPERTY_VELOCITY, 1E-18, "am/s"),
  UNIT_fmps  (PropertyBaseUnit.PROPERTY_VELOCITY, 1E-15, "fm/s"),
  UNIT_pmps  (PropertyBaseUnit.PROPERTY_VELOCITY, 1E-12, "pm/s"),
  UNIT_nmps  (PropertyBaseUnit.PROPERTY_VELOCITY, 1E-9,  "nm/s"),
  UNIT_mumps (PropertyBaseUnit.PROPERTY_VELOCITY, 1E-6,  "\u03BCm/s"),
  UNIT_mmps  (PropertyBaseUnit.PROPERTY_VELOCITY, 1E-3,  "mm/s"),
  UNIT_cmps  (PropertyBaseUnit.PROPERTY_VELOCITY, 1E-2,  "cm/s"),
  UNIT_dmps  (PropertyBaseUnit.PROPERTY_VELOCITY, 1E-1,  "dm/s"),
  UNIT_mps   (PropertyBaseUnit.PROPERTY_VELOCITY, 1,     "m/s"),
  UNIT_damps (PropertyBaseUnit.PROPERTY_VELOCITY, 1E1,   "dam/s"),
  UNIT_hmps  (PropertyBaseUnit.PROPERTY_VELOCITY, 1E2,   "hm/s"),
  UNIT_kmps  (PropertyBaseUnit.PROPERTY_VELOCITY, 1E3,   "km/s"),
  UNIT_Mmps  (PropertyBaseUnit.PROPERTY_VELOCITY, 1E6,   "Mm/s"),
  UNIT_Gmps  (PropertyBaseUnit.PROPERTY_VELOCITY, 1E9,   "Gm/s"),
  UNIT_Tmps  (PropertyBaseUnit.PROPERTY_VELOCITY, 1E12,  "Tm/s"),
  
  ;
  
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  //
  // CONSTRUCTOR(S) / FACTORY / CLONING
  //
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  Unit (
    final PropertyBaseUnit propertyBaseUnit,
    final Function<Double, Double> toSiUnit,
    final Function<Double, Double> fromSiUnit,
    final boolean multiplicativeToSiUnit,
    final String string)
  {
    this.propertyBaseUnit = propertyBaseUnit;
    this.toSiUnit = toSiUnit;
    this.fromSiUnit = fromSiUnit;
    this.multiplicativeToSiUnit = multiplicativeToSiUnit;
    this.string = string;
  }
  
  Unit (
    final PropertyBaseUnit propertyBaseUnit,
    final double toSiUnitFactor,
    final String string)
  {
    this (propertyBaseUnit, (d) -> toSiUnitFactor * d, (d) -> d / toSiUnitFactor, true, string);
  }
  
  Unit (
    final PropertyBaseUnit propertyBaseUnit,
    final Function<Double, Double> toSiUnit,
    final Function<Double, Double> fromSiUnit,
    final String string)
  {
    this (propertyBaseUnit, toSiUnit, fromSiUnit, false, string);
  }
  
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  //
  // QUANTITY
  //
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  private final PropertyBaseUnit propertyBaseUnit;
  
  public final PropertyBaseUnit getPropertyBaseUnit ()
  {
    return this.propertyBaseUnit;
  }
  
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  //
  // TO / FROM SI UNIT
  //
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  private final Function<Double, Double> toSiUnit;
  
  public final Function<Double, Double> getToSiUnit ()
  {
    return this.toSiUnit;
  }
  
  private final Function<Double, Double> fromSiUnit;
  
  public final Function<Double, Double> getFromSiUnit ()
  {
    return this.fromSiUnit;
  }
  
  public final boolean isSiUnit ()
  {
    return this.propertyBaseUnit.getSiUnit () == this;
  }
  
  private final boolean multiplicativeToSiUnit;

  public final boolean isMultiplicativeToSiUnit ()
  {
    return this.multiplicativeToSiUnit;
  }
  
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  //
  // NAME / toString
  //
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
  private final String string;

  @Override
  public String toString ()
  {
    return this.string;
  }
  
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  //
  // UNIT CONVERSION
  //
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  public static final double convertToUnit (final double magnitude, final Unit fromUnit, final Unit toUnit)
  {
    if (fromUnit == null || toUnit == null)
      throw new IllegalArgumentException ();
    if (fromUnit == toUnit)
      return magnitude;
    final PropertyBaseUnit fromPropertyBaseUnit = fromUnit.getPropertyBaseUnit ();
    final PropertyBaseUnit toPropertyBaseUnit = toUnit.getPropertyBaseUnit ();
    if (fromPropertyBaseUnit == toPropertyBaseUnit)
      return toUnit.getFromSiUnit ().apply (fromUnit.getToSiUnit ().apply (magnitude));
    if (! PropertyBaseUnit.canConvert (fromPropertyBaseUnit, toPropertyBaseUnit))
      throw new IllegalArgumentException ();
    final double fromSi = fromUnit.getToSiUnit ().apply (magnitude);
    final double toSi = PropertyBaseUnit.convert (fromSi, fromPropertyBaseUnit, toPropertyBaseUnit);
    final double to = toUnit.getFromSiUnit ().apply (toSi);
    return to;
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  //
  // AUTO RANGE
  //
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  private enum AutoRangeBin
  {
    
    INTERVAL_1000_POS_INFTY (1000, Double.POSITIVE_INFINITY),
    INTERVAL_100_1000       (100, 1000),
    INTERVAL_10_100         (10, 100),
    INTERVAL_1_10           (1, 10),
    INTERVAL_0p1_1          (0.1, 1),
    INTERVAL_0p01_0p1       (0.01, 0.1),
    INTERVAL_0p001_0p01     (0.001, 0.01),
    INTERVAL_ZERO_p001      (0, 0.001);

    private AutoRangeBin (final double rangeMin, final double rangeMax)
    {
      this.rangeMin = rangeMin;
      this.rangeMax = rangeMax;
    }
    
    private final double rangeMin;

    public final double getRangeMin ()
    {
      return this.rangeMin;
    }

    private final double rangeMax;
    
    public final double getRangeMax ()
    {
      return this.rangeMax;
    }
   
    public final static AutoRangeBin fromDouble (final double d)
    {
      if (d < 0)
        return fromDouble (-d);
      for (final AutoRangeBin bin : AutoRangeBin.values ())
        if (d >= bin.getRangeMin () && d < bin.getRangeMax ())
          return bin;
      throw new RuntimeException ();
    }
    
  }
  
  public static enum AutoRangePolicy
  {
    
    PREFER_1_1000 (2),
    PREFER_1_100  (1),
    PREFER_1_10   (0),
    PREFER_0p1_1  (0);
    
    private AutoRangePolicy (final int preferredDecimalPointIndex)
    {
      this.preferredDecimalPointIndex = preferredDecimalPointIndex;
    }
    
    private final int preferredDecimalPointIndex;
    
    public final int getPreferredDecimalPointIndex ()
    {
      return this.preferredDecimalPointIndex;
    }
    
  }
  
  private static double scoreMagnitude (final AutoRangePolicy autoRangePolicy, final double magnitude)
  {
    if (autoRangePolicy == null)
      throw new IllegalArgumentException ();
    if (magnitude < 0)
      return scoreMagnitude (autoRangePolicy, -magnitude);
    final AutoRangeBin autoRangeBin = AutoRangeBin.fromDouble (magnitude);
    switch (autoRangeBin)
    {
      case INTERVAL_1000_POS_INFTY:
        switch (autoRangePolicy)
        {
          case PREFER_1_1000:
            return -magnitude/1000;
          case PREFER_1_100:
            return -magnitude/100;
          case PREFER_1_10:
            return -magnitude/10;
          case PREFER_0p1_1:
            return -magnitude;
          default:
            throw new RuntimeException ();
        }
      case INTERVAL_100_1000:
        switch (autoRangePolicy)
        {
          case PREFER_1_1000:
            return magnitude;
          case PREFER_1_100:
            return -magnitude/100;
          case PREFER_1_10:
            return -magnitude/10;
          case PREFER_0p1_1:
            return -magnitude;
          default:
            throw new RuntimeException ();
        }
      case INTERVAL_10_100:
        switch (autoRangePolicy)
        {
          case PREFER_1_1000:
            return magnitude / 10;
          case PREFER_1_100:
            return magnitude;
          case PREFER_1_10:
            return -magnitude/10;
          case PREFER_0p1_1:
            return -magnitude;
          default:
            throw new RuntimeException ();
        }
      case INTERVAL_1_10:
        switch (autoRangePolicy)
        {
          case PREFER_1_1000:
            return magnitude / 100;
          case PREFER_1_100:
            return magnitude / 10;
          case PREFER_1_10:
            return magnitude;
          case PREFER_0p1_1:
            return -magnitude;
          default:
            throw new RuntimeException ();
        }
      case INTERVAL_0p1_1:
        switch (autoRangePolicy)
        {
          case PREFER_1_1000:
            return -magnitude;
          case PREFER_1_100:
            return -magnitude;
          case PREFER_1_10:
            return -magnitude;
          case PREFER_0p1_1:
            return magnitude;
          default:
            throw new RuntimeException ();
        }
      case INTERVAL_0p01_0p1:
      case INTERVAL_0p001_0p01:
      case INTERVAL_ZERO_p001:
        return -magnitude;
      default:
        throw new RuntimeException ();
    }
  }
  
  public static final Unit autoRange (
    final AutoRangePolicy autoRangePolicy,
    final double magnitude,
    final Unit fromUnit,
    final Resolution fromResolution,
    final Unit[] toUnits,
    final Resolution toResolution,
    final boolean strictPropertyBaseUnit,
    final boolean round)
  {
    if (autoRangePolicy == null)
      throw new IllegalArgumentException ();
    if (fromUnit == null)
      throw new IllegalArgumentException ();
    if (toUnits == null || toUnits.length == 0)
      return fromUnit;
    final SortedMap<Double, Set<Unit>> unitScores = new TreeMap<> ();
    final double defaultScore = scoreMagnitude (autoRangePolicy, magnitude);
    unitScores.put (defaultScore, new LinkedHashSet<> ());
    unitScores.get (defaultScore).add (fromUnit);
    for (final Unit toUnit : toUnits)
      if (toUnit != fromUnit)
      {
        if (strictPropertyBaseUnit && fromUnit.getPropertyBaseUnit () != toUnit.getPropertyBaseUnit ())
          continue;
        final double unitScore = scoreMagnitude (autoRangePolicy, Unit.convertToUnit (magnitude, fromUnit, toUnit));
        if (unitScore < unitScores.lastKey ())
          continue;
        if (! unitScores.containsKey (unitScore))
          unitScores.put (unitScore, new LinkedHashSet<> ());
        unitScores.get (unitScore).add (toUnit);
      }
    return unitScores.get (unitScores.lastKey ()).iterator ().next ();
  }
  
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  //
  // END OF FILE
  //
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
}
