package xyz.gwcr.poisonedForest.ThrowHead

import org.bukkit.plugin.java.JavaPlugin
import xyz.gwcr.poisonedForest.ThrowHead.commands.GetHeadThrowStick

class Main : JavaPlugin() {

    fun getThis(): JavaPlugin {
            return this
    }


    override fun onEnable() {

        getCommand("던지기아이템")?.setExecutor(GetHeadThrowStick())

        println("[ INFO ] Throw Head is enabled~!!!!!!")
    }
}