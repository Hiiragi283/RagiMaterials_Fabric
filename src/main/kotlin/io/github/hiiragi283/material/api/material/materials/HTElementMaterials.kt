package io.github.hiiragi283.material.api.material.materials

import io.github.hiiragi283.material.HTMaterialsCommon
import io.github.hiiragi283.material.api.HTMaterialsAddon
import io.github.hiiragi283.material.api.material.ColorConvertible
import io.github.hiiragi283.material.api.material.FormulaConvertible
import io.github.hiiragi283.material.api.material.HTMaterialKey
import io.github.hiiragi283.material.api.material.MolarMassConvertible
import io.github.hiiragi283.material.api.material.flag.HTMaterialFlagSet
import io.github.hiiragi283.material.api.material.flag.HTMaterialFlags
import io.github.hiiragi283.material.api.material.property.HTFluidProperty
import io.github.hiiragi283.material.api.material.property.HTMaterialPropertyMap
import io.github.hiiragi283.material.api.material.property.HTMetalProperty
import io.github.hiiragi283.material.api.registry.HTDefaultedMap
import io.github.hiiragi283.material.api.registry.HTObjectKeySet
import io.github.hiiragi283.material.util.HTColor
import java.awt.Color

object HTElementMaterials : HTMaterialsAddon {

    //    1st Period    //

    @JvmField
    val HYDROGEN = HTMaterialKey("hydrogen")

    @JvmField
    val HELIUM = HTMaterialKey("helium")

    //    2nd Period    //

    @JvmField
    val LITHIUM = HTMaterialKey("lithium")

    @JvmField
    val BERYLLIUM = HTMaterialKey("beryllium")

    @JvmField
    val CARBON = HTMaterialKey("carbon")

    @JvmField
    val NITROGEN = HTMaterialKey("nitrogen")

    @JvmField
    val OXYGEN = HTMaterialKey("oxygen")

    @JvmField
    val FLUORINE = HTMaterialKey("fluorine")

    //    3rd Period    //

    @JvmField
    val SODIUM = HTMaterialKey("sodium")

    @JvmField
    val MAGNESIUM = HTMaterialKey("magnesium")

    @JvmField
    val ALUMINUM = HTMaterialKey("aluminum")

    @JvmField
    val SILICON = HTMaterialKey("silicon")

    @JvmField
    val PHOSPHORUS = HTMaterialKey("phosphorus")

    @JvmField
    val SULFUR = HTMaterialKey("sulfur")

    @JvmField
    val CHLORINE = HTMaterialKey("chlorine")

    //    4th Period    //

    @JvmField
    val POTASSIUM = HTMaterialKey("potassium")

    @JvmField
    val CALCIUM = HTMaterialKey("calcium")

    @JvmField
    val TITANIUM = HTMaterialKey("titanium")

    @JvmField
    val CHROMIUM = HTMaterialKey("chromium")

    @JvmField
    val MANGANESE = HTMaterialKey("manganese")

    @JvmField
    val IRON = HTMaterialKey("iron")

    @JvmField
    val COBALT = HTMaterialKey("cobalt")

    @JvmField
    val NICKEL = HTMaterialKey("nickel")

    @JvmField
    val COPPER = HTMaterialKey("copper")

    @JvmField
    val ZINC = HTMaterialKey("zinc")

    //    5th Period    //

    @JvmField
    val SILVER = HTMaterialKey("silver")

    @JvmField
    val TIN = HTMaterialKey("tin")

    //    6th Period    //

    @JvmField
    val TUNGSTEN = HTMaterialKey("tungsten")

    @JvmField
    val IRIDIUM = HTMaterialKey("iridium")

    @JvmField
    val PLATINUM = HTMaterialKey("platinum")

    @JvmField
    val GOLD = HTMaterialKey("gold")

    @JvmField
    val MERCURY = HTMaterialKey("mercury")

    @JvmField
    val LEAD = HTMaterialKey("lead")

    //    7th Period    //

    @JvmField
    val URANIUM = HTMaterialKey("uranium")

    @JvmField
    val PLUTONIUM = HTMaterialKey("plutonium")

    //    Register    //

    override val modId: String = HTMaterialsCommon.MOD_ID

    override val priority: Int = -100

    override fun registerMaterialKey(registry: HTObjectKeySet<HTMaterialKey>) {
        //1st Period
        registry.addAll(
            HYDROGEN,
            HELIUM
        )
        //2nd Period
        registry.addAll(
            LITHIUM,
            BERYLLIUM,
            CARBON,
            NITROGEN,
            OXYGEN,
            FLUORINE
        )
        //3rd Period
        registry.addAll(
            SODIUM,
            MAGNESIUM,
            ALUMINUM,
            SILICON,
            PHOSPHORUS,
            SULFUR,
            CHLORINE
        )
        //4th Period
        registry.addAll(
            POTASSIUM,
            CALCIUM,
            TITANIUM,
            CHROMIUM,
            MANGANESE,
            IRON,
            COBALT,
            NICKEL,
            COPPER,
            ZINC
        )
        //5th Period
        registry.addAll(
            SILVER,
            TIN
        )
        //6th Period
        registry.addAll(
            TUNGSTEN,
            IRIDIUM,
            PLATINUM,
            GOLD,
            MERCURY,
            LEAD
        )
        //7th Period
        registry.addAll(
            URANIUM,
            PLUTONIUM
        )
    }

    override fun modifyMaterialProperty(registry: HTDefaultedMap<HTMaterialKey, HTMaterialPropertyMap.Builder>) {
        //1st Period
        registry.getOrCreate(HYDROGEN).add(HTFluidProperty()) { this.isGas = true }
        registry.getOrCreate(HELIUM).add(HTFluidProperty()) { this.isGas = true }
        //2nd Period
        registry.getOrCreate(LITHIUM).add(HTMetalProperty)
        registry.getOrCreate(BERYLLIUM).add(HTMetalProperty)
        registry.getOrCreate(NITROGEN).add(HTFluidProperty()) { this.isGas = true }
        registry.getOrCreate(OXYGEN).add(HTFluidProperty()) { this.isGas = true }
        registry.getOrCreate(FLUORINE).add(HTFluidProperty()) { this.isGas = true }
        //3rd Period
        registry.getOrCreate(SODIUM).add(HTMetalProperty)
        registry.getOrCreate(MAGNESIUM).add(HTMetalProperty)
        registry.getOrCreate(ALUMINUM).add(HTMetalProperty)
        registry.getOrCreate(SILICON).add(HTMetalProperty)
        registry.getOrCreate(SODIUM).add(HTFluidProperty()) { this.isGas = true }
        //4th Period
        registry.getOrCreate(POTASSIUM).add(HTMetalProperty)
        registry.getOrCreate(CALCIUM).add(HTMetalProperty)
        registry.getOrCreate(TITANIUM).add(HTMetalProperty)
        registry.getOrCreate(CHROMIUM).add(HTMetalProperty)
        registry.getOrCreate(MANGANESE).add(HTMetalProperty)
        registry.getOrCreate(IRON).add(HTMetalProperty)
        registry.getOrCreate(COBALT).add(HTMetalProperty)
        registry.getOrCreate(NICKEL).add(HTMetalProperty)
        registry.getOrCreate(COPPER).add(HTMetalProperty)
        registry.getOrCreate(ZINC).add(HTMetalProperty)
        //5th Period
        registry.getOrCreate(SILVER).add(HTMetalProperty)
        registry.getOrCreate(TIN).add(HTMetalProperty)
        //6th Period
        registry.getOrCreate(TUNGSTEN).add(HTMetalProperty)
        registry.getOrCreate(IRIDIUM).add(HTMetalProperty)
        registry.getOrCreate(PLATINUM).add(HTMetalProperty)
        registry.getOrCreate(GOLD).add(HTMetalProperty)
        registry.getOrCreate(MERCURY).add(HTFluidProperty())
        registry.getOrCreate(LEAD).add(HTMetalProperty)
        //7th Period
        registry.getOrCreate(URANIUM).add(HTMetalProperty)
        registry.getOrCreate(PLUTONIUM).add(HTMetalProperty)
    }

    override fun modifyMaterialFlag(registry: HTDefaultedMap<HTMaterialKey, HTMaterialFlagSet.Builder>) {
        //1st Period

        //2nd Period
        registry.getOrCreate(CARBON).apply {
            add(HTMaterialFlags.GENERATE_DUST)
            add(HTMaterialFlags.GENERATE_PLATE)
        }
        //3rd Period
        registry.getOrCreate(ALUMINUM).apply {
            add(HTMaterialFlags.GENERATE_BLOCk)
            add(HTMaterialFlags.GENERATE_DUST)
            add(HTMaterialFlags.GENERATE_GEAR)
            add(HTMaterialFlags.GENERATE_INGOT)
            add(HTMaterialFlags.GENERATE_NUGGET)
            add(HTMaterialFlags.GENERATE_PLATE)
            add(HTMaterialFlags.GENERATE_ROD)
        }
        registry.getOrCreate(SILICON).apply {
            add(HTMaterialFlags.GENERATE_DUST)
            add(HTMaterialFlags.GENERATE_INGOT)
            add(HTMaterialFlags.GENERATE_NUGGET)
            add(HTMaterialFlags.GENERATE_PLATE)
            add(HTMaterialFlags.GENERATE_ROD)
        }
        registry.getOrCreate(PHOSPHORUS).apply {
            add(HTMaterialFlags.GENERATE_DUST)
        }
        registry.getOrCreate(SULFUR).apply {
            add(HTMaterialFlags.GENERATE_DUST)
        }
        //4th Period
        registry.getOrCreate(TITANIUM).apply {
            add(HTMaterialFlags.GENERATE_BLOCk)
            add(HTMaterialFlags.GENERATE_DUST)
            add(HTMaterialFlags.GENERATE_GEAR)
            add(HTMaterialFlags.GENERATE_INGOT)
            add(HTMaterialFlags.GENERATE_NUGGET)
            add(HTMaterialFlags.GENERATE_PLATE)
            add(HTMaterialFlags.GENERATE_ROD)
        }
        registry.getOrCreate(IRON).apply {
            add(HTMaterialFlags.GENERATE_DUST)
            add(HTMaterialFlags.GENERATE_GEAR)
            add(HTMaterialFlags.GENERATE_PLATE)
            add(HTMaterialFlags.GENERATE_ROD)
        }
        registry.getOrCreate(NICKEL).apply {
            add(HTMaterialFlags.GENERATE_BLOCk)
            add(HTMaterialFlags.GENERATE_DUST)
            add(HTMaterialFlags.GENERATE_GEAR)
            add(HTMaterialFlags.GENERATE_INGOT)
            add(HTMaterialFlags.GENERATE_NUGGET)
            add(HTMaterialFlags.GENERATE_PLATE)
            add(HTMaterialFlags.GENERATE_ROD)
        }
        registry.getOrCreate(COPPER).apply {
            add(HTMaterialFlags.GENERATE_DUST)
            add(HTMaterialFlags.GENERATE_GEAR)
            add(HTMaterialFlags.GENERATE_NUGGET)
            add(HTMaterialFlags.GENERATE_PLATE)
            add(HTMaterialFlags.GENERATE_ROD)
        }
        registry.getOrCreate(ZINC).apply {
            add(HTMaterialFlags.GENERATE_BLOCk)
            add(HTMaterialFlags.GENERATE_DUST)
            add(HTMaterialFlags.GENERATE_GEAR)
            add(HTMaterialFlags.GENERATE_INGOT)
            add(HTMaterialFlags.GENERATE_NUGGET)
            add(HTMaterialFlags.GENERATE_PLATE)
            add(HTMaterialFlags.GENERATE_ROD)
        }
        //5th Period
        registry.getOrCreate(SILVER).apply {
            add(HTMaterialFlags.GENERATE_BLOCk)
            add(HTMaterialFlags.GENERATE_DUST)
            add(HTMaterialFlags.GENERATE_GEAR)
            add(HTMaterialFlags.GENERATE_INGOT)
            add(HTMaterialFlags.GENERATE_NUGGET)
            add(HTMaterialFlags.GENERATE_PLATE)
            add(HTMaterialFlags.GENERATE_ROD)
        }
        registry.getOrCreate(TIN).apply {
            add(HTMaterialFlags.GENERATE_BLOCk)
            add(HTMaterialFlags.GENERATE_DUST)
            add(HTMaterialFlags.GENERATE_GEAR)
            add(HTMaterialFlags.GENERATE_INGOT)
            add(HTMaterialFlags.GENERATE_NUGGET)
            add(HTMaterialFlags.GENERATE_PLATE)
            add(HTMaterialFlags.GENERATE_ROD)
        }
        //6th Period
        registry.getOrCreate(TUNGSTEN).apply {
            add(HTMaterialFlags.GENERATE_BLOCk)
            add(HTMaterialFlags.GENERATE_DUST)
            add(HTMaterialFlags.GENERATE_GEAR)
            add(HTMaterialFlags.GENERATE_INGOT)
            add(HTMaterialFlags.GENERATE_NUGGET)
            add(HTMaterialFlags.GENERATE_PLATE)
            add(HTMaterialFlags.GENERATE_ROD)
        }
        registry.getOrCreate(IRIDIUM).apply {
            add(HTMaterialFlags.GENERATE_BLOCk)
            add(HTMaterialFlags.GENERATE_DUST)
            add(HTMaterialFlags.GENERATE_GEAR)
            add(HTMaterialFlags.GENERATE_INGOT)
            add(HTMaterialFlags.GENERATE_NUGGET)
            add(HTMaterialFlags.GENERATE_PLATE)
            add(HTMaterialFlags.GENERATE_ROD)
        }
        registry.getOrCreate(PLATINUM).apply {
            add(HTMaterialFlags.GENERATE_BLOCk)
            add(HTMaterialFlags.GENERATE_DUST)
            add(HTMaterialFlags.GENERATE_GEAR)
            add(HTMaterialFlags.GENERATE_INGOT)
            add(HTMaterialFlags.GENERATE_NUGGET)
            add(HTMaterialFlags.GENERATE_PLATE)
            add(HTMaterialFlags.GENERATE_ROD)
        }
        registry.getOrCreate(GOLD).apply {
            add(HTMaterialFlags.GENERATE_DUST)
            add(HTMaterialFlags.GENERATE_GEAR)
            add(HTMaterialFlags.GENERATE_PLATE)
            add(HTMaterialFlags.GENERATE_ROD)
        }
        registry.getOrCreate(LEAD).apply {
            add(HTMaterialFlags.GENERATE_BLOCk)
            add(HTMaterialFlags.GENERATE_DUST)
            add(HTMaterialFlags.GENERATE_GEAR)
            add(HTMaterialFlags.GENERATE_INGOT)
            add(HTMaterialFlags.GENERATE_NUGGET)
            add(HTMaterialFlags.GENERATE_PLATE)
            add(HTMaterialFlags.GENERATE_ROD)
        }
        //7th Period
        registry.getOrCreate(URANIUM).apply {
            add(HTMaterialFlags.GENERATE_BLOCk)
            add(HTMaterialFlags.GENERATE_DUST)
            add(HTMaterialFlags.GENERATE_INGOT)
            add(HTMaterialFlags.GENERATE_NUGGET)
            add(HTMaterialFlags.GENERATE_PLATE)
            add(HTMaterialFlags.GENERATE_ROD)
        }
        registry.getOrCreate(PLUTONIUM).apply {
            add(HTMaterialFlags.GENERATE_BLOCk)
            add(HTMaterialFlags.GENERATE_DUST)
            add(HTMaterialFlags.GENERATE_INGOT)
            add(HTMaterialFlags.GENERATE_NUGGET)
            add(HTMaterialFlags.GENERATE_PLATE)
            add(HTMaterialFlags.GENERATE_ROD)
        }
    }

    override fun modifyMaterialColor(registry: MutableMap<HTMaterialKey, ColorConvertible>) {
        //1st Period
        registry[HYDROGEN] = ColorConvertible { HTColor.BLUE }
        registry[HELIUM] = ColorConvertible { HTColor.YELLOW }
        //2nd Period
        registry[LITHIUM] = ColorConvertible { HTColor.GRAY }
        registry[BERYLLIUM] = ColorConvertible { HTColor.DARK_GREEN }
        registry[CARBON] = ColorConvertible.ofColor(HTColor.BLACK, HTColor.DARK_GRAY)
        registry[NITROGEN] = ColorConvertible { HTColor.AQUA }
        registry[OXYGEN] = ColorConvertible { HTColor.WHITE }
        registry[FLUORINE] = ColorConvertible { HTColor.GREEN }
        //3rd Period
        registry[SODIUM] = ColorConvertible.ofColor(HTColor.DARK_BLUE to 1, HTColor.BLUE to 4)
        registry[MAGNESIUM] = ColorConvertible { HTColor.GRAY }
        registry[ALUMINUM] = ColorConvertible.ofColor(HTColor.BLUE to 1, HTColor.WHITE to 5)
        registry[SILICON] = ColorConvertible.ofColor(HTColor.BLACK to 2, HTColor.GRAY to 1, HTColor.BLUE to 1)
        registry[PHOSPHORUS] = ColorConvertible { HTColor.YELLOW }
        registry[SULFUR] = ColorConvertible.ofColor(HTColor.GOLD, HTColor.YELLOW)
        registry[CHLORINE] = ColorConvertible { HTColor.YELLOW }
        //4th Period
        registry[POTASSIUM] = ColorConvertible.ofColor(HTColor.DARK_BLUE to 2, HTColor.BLUE to 3)
        registry[CALCIUM] = ColorConvertible { HTColor.GRAY }
        registry[TITANIUM] = ColorConvertible.ofColor(HTColor.GOLD to 1, HTColor.WHITE to 2)
        registry[CHROMIUM] = ColorConvertible { HTColor.GREEN }
        registry[MANGANESE] = ColorConvertible { HTColor.GRAY }
        registry[IRON] = ColorConvertible { HTColor.WHITE }
        registry[COBALT] = ColorConvertible { HTColor.BLUE }
        registry[NICKEL] = ColorConvertible.ofColor(HTColor.GOLD to 2, HTColor.GREEN to 1, HTColor.WHITE to 1)
        registry[COPPER] = ColorConvertible.ofColor(HTColor.GOLD, HTColor.RED)
        registry[ZINC] = ColorConvertible.ofColor(HTColor.GREEN to 1, HTColor.WHITE to 2)
        //5th Period
        registry[SILVER] = ColorConvertible.ofColor(HTColor.AQUA to 1, HTColor.WHITE to 3)
        registry[TIN] = ColorConvertible.ofColor(HTColor.BLUE to 1, HTColor.AQUA to 1, HTColor.WHITE to 3)
        //6th Period
        registry[TUNGSTEN] = ColorConvertible.ofColor(HTColor.BLACK to 2, HTColor.DARK_GRAY to 1)
        registry[IRIDIUM] = ColorConvertible { HTColor.WHITE }
        registry[PLATINUM] = ColorConvertible { Color(0x87cefa) }
        registry[GOLD] = ColorConvertible.ofColor(HTColor.GOLD, HTColor.YELLOW)
        registry[MERCURY] = ColorConvertible { HTColor.WHITE }
        registry[LEAD] = ColorConvertible.ofColor(HTColor.DARK_BLUE, HTColor.DARK_GRAY, HTColor.WHITE)
        //7th Period
        registry[URANIUM] = ColorConvertible { HTColor.GREEN }
        registry[PLUTONIUM] = ColorConvertible { HTColor.RED }
    }

    override fun modifyMaterialFormula(registry: MutableMap<HTMaterialKey, FormulaConvertible>) {
        //1st Period
        registry[HYDROGEN] = FormulaConvertible { "H" }
        registry[HELIUM] = FormulaConvertible { "He" }
        //2nd Period
        registry[LITHIUM] = FormulaConvertible { "Li" }
        registry[BERYLLIUM] = FormulaConvertible { "Be" }
        registry[CARBON] = FormulaConvertible { "C" }
        registry[NITROGEN] = FormulaConvertible { "N" }
        registry[OXYGEN] = FormulaConvertible { "O" }
        registry[FLUORINE] = FormulaConvertible { "F" }
        //3rd Period
        registry[SODIUM] = FormulaConvertible { "Na" }
        registry[MAGNESIUM] = FormulaConvertible { "Mg" }
        registry[ALUMINUM] = FormulaConvertible { "Al" }
        registry[SILICON] = FormulaConvertible { "Si" }
        registry[PHOSPHORUS] = FormulaConvertible { "P" }
        registry[SULFUR] = FormulaConvertible { "S" }
        registry[CHLORINE] = FormulaConvertible { "Cl" }
        //4th Period
        registry[POTASSIUM] = FormulaConvertible { "K" }
        registry[CALCIUM] = FormulaConvertible { "Ca" }
        registry[TITANIUM] = FormulaConvertible { "Ti" }
        registry[CHROMIUM] = FormulaConvertible { "Cr" }
        registry[MANGANESE] = FormulaConvertible { "Mn" }
        registry[IRON] = FormulaConvertible { "Fe" }
        registry[COBALT] = FormulaConvertible { "Co" }
        registry[NICKEL] = FormulaConvertible { "Ni" }
        registry[COPPER] = FormulaConvertible { "Cu" }
        registry[ZINC] = FormulaConvertible { "Zn" }
        //5th Period
        registry[SILVER] = FormulaConvertible { "Ag" }
        registry[TIN] = FormulaConvertible { "Sn" }
        //6th Period
        registry[TUNGSTEN] = FormulaConvertible { "W" }
        registry[IRIDIUM] = FormulaConvertible { "Ir" }
        registry[PLATINUM] = FormulaConvertible { "Pt" }
        registry[GOLD] = FormulaConvertible { "Au" }
        registry[MERCURY] = FormulaConvertible { "Hg" }
        registry[LEAD] = FormulaConvertible { "Pb" }
        //7th Period
        registry[URANIUM] = FormulaConvertible { "U" }
        registry[PLUTONIUM] = FormulaConvertible { "Pu" }
    }

    override fun modifyMaterialMolar(registry: MutableMap<HTMaterialKey, MolarMassConvertible>) {
        //1st Period
        registry[HYDROGEN] = MolarMassConvertible { 1.0 }
        registry[HELIUM] = MolarMassConvertible { 4.0 }
        //2nd Period
        registry[LITHIUM] = MolarMassConvertible { 6.9 }
        registry[BERYLLIUM] = MolarMassConvertible { 9.0 }
        registry[CARBON] = MolarMassConvertible { 12.0 }
        registry[NITROGEN] = MolarMassConvertible { 14.0 }
        registry[OXYGEN] = MolarMassConvertible { 16.0 }
        registry[FLUORINE] = MolarMassConvertible { 19.0 }
        //3rd Period
        registry[SODIUM] = MolarMassConvertible { 23.0 }
        registry[MAGNESIUM] = MolarMassConvertible { 24.3 }
        registry[ALUMINUM] = MolarMassConvertible { 27.0 }
        registry[SILICON] = MolarMassConvertible { 28.1 }
        registry[PHOSPHORUS] = MolarMassConvertible { 31.0 }
        registry[SULFUR] = MolarMassConvertible { 32.1 }
        registry[CHLORINE] = MolarMassConvertible { 35.5 }
        //4th Period
        registry[POTASSIUM] = MolarMassConvertible { 39.1 }
        registry[CALCIUM] = MolarMassConvertible { 40.1 }
        registry[TITANIUM] = MolarMassConvertible { 47.9 }
        registry[CHROMIUM] = MolarMassConvertible { 52.0 }
        registry[MANGANESE] = MolarMassConvertible { 54.9 }
        registry[IRON] = MolarMassConvertible { 55.8 }
        registry[COBALT] = MolarMassConvertible { 58.9 }
        registry[NICKEL] = MolarMassConvertible { 58.7 }
        registry[COPPER] = MolarMassConvertible { 63.5 }
        registry[ZINC] = MolarMassConvertible { 65.4 }
        //5th Period
        registry[SILVER] = MolarMassConvertible { 107.9 }
        registry[TIN] = MolarMassConvertible { 118.7 }
        //6th Period
        registry[TUNGSTEN] = MolarMassConvertible { 183.8 }
        registry[IRIDIUM] = MolarMassConvertible { 192.2 }
        registry[PLATINUM] = MolarMassConvertible { 195.1 }
        registry[GOLD] = MolarMassConvertible { 197.0 }
        registry[MERCURY] = MolarMassConvertible { 200.6 }
        registry[LEAD] = MolarMassConvertible { 207.2 }
        //7th Period
        registry[URANIUM] = MolarMassConvertible { 238.0 }
        registry[PLUTONIUM] = MolarMassConvertible { 244.1 }
    }

}