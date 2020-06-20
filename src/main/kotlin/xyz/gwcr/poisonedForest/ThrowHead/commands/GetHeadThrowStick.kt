package xyz.gwcr.poisonedForest.ThrowHead.commands

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import xyz.gwcr.poisonedForest.ThrowHead.Main

class GetHeadThrowStick : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(!sender.hasPermission("throwhead.getstick") || !sender.isOp) {
            sender.sendMessage("권한이 없습니다.")
            return true
        }

        if(args.isEmpty()) {
            sender.sendMessage("올바른 사용법: /던지기아이템 <플레이어 이름>")
            return true
        }

        var item: ItemStack = ItemStack(Material.STICK)
        var meta: ItemMeta? = item.itemMeta

        meta?.setDisplayName("${args[0]}님의 머리를 던지는 막대")
        meta?.lore = listOf("전설의 ${args[0]}의 머리를 던지는 막대!")
        item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1)

        item.setItemMeta(meta)

        var senderr: Player = sender as Player
        senderr.inventory.addItem(item)

        sender.sendMessage("획득하였습니다.")

        return true
    }
}