package io.github.onebytegh.ostuplugs.events;

import io.github.onebytegh.ostuplugs.OStuPlugins;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

//I KNOW I SHOULDN'T USE ONE FILE BUT I AM NOT THAT CREATIVE THAT I CAN NAME ALL OF THEM UNDER JAVA's LIMITS
public class Events {
    private final OStuPlugins plugin;

    public Events(OStuPlugins oStuPlugins) {
        this.plugin = oStuPlugins;
    }


    //IDEA 2: Everytime you break a block, a villager spawns and says a Sun Tzu quote
    @EventHandler
    public void breakBlockEvent(BlockBreakEvent event) {
        if(!plugin.getMap().get(2)) return;
        Location loc = event.getBlock().getLocation().add(5, 0, 5);

        Villager villager = (Villager) loc.getWorld().spawnEntity(loc, org.bukkit.entity.EntityType.VILLAGER);
        villager.setCustomName("Sun Tzu");
        villager.setCustomNameVisible(true);
        villager.setTarget(event.getPlayer());

        event.getPlayer().sendMessage("Sun Tzu: " + quotes[(int) (Math.random() * quotes.length)]);
    }

    //IDEA 3: Minecraft but touching the grass kills you
    @EventHandler
    public void touchGrassEvent(BlockBreakEvent event) {
        if(!plugin.getMap().get(3)) return;
        if(event.getBlock().getType().name().equals("GRASS")) {
            event.getPlayer().sendMessage("You touched the grass and died");
            event.getPlayer().setHealth(0);
        }
    }
    @EventHandler
    public void onWalkOnGrassEvent(PlayerMoveEvent event) {
        if(!plugin.getMap().get(3)) return;
        if(event.getTo().getBlock().getType().name().equals("GRASS")) {
            event.getPlayer().sendMessage("You touched the grass and died");
            event.getPlayer().setHealth(0);
        }
    }

    //IDEA 4: Minecraft but when you take damage, it rickrolls you
    @EventHandler
    public void takeDamageEvent(EntityDamageEvent event) {
        if(!plugin.getMap().get(4)) return;
        if(event.getEntityType() != EntityType.PLAYER) return;

        //get the block behind the player
        Vector inverseDirectionVec = event.getEntity().getLocation().getDirection().normalize().multiply(-1);
        Location loc = event.getEntity().getLocation().add(inverseDirectionVec);

        //spawn the villager
        Villager villager = (Villager) loc.getWorld().spawnEntity(loc, EntityType.VILLAGER);
        villager.setCustomName("NOT SUS AT ALL VILLAGER");
        villager.setCustomNameVisible(true);
        villager.setTarget((LivingEntity) event.getEntity());

        //changes the name after 2 seconds
        plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> villager.setCustomName("Never gonna give you up"), 20 * 2);
    }

    //IDEA 5: Minecraft but you cant mine or craft
    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {
        if(!plugin.getMap().get(5)) return;
        event.getPlayer().getWorld().setType(event.getBlock().getLocation(), event.getBlock().getType());
        event.getPlayer().sendMessage("Oh no no no, we don't do that here");
    }
    @EventHandler
    public void onCraftEvent(CraftItemEvent event) {
        if(!plugin.getMap().get(5)) return;
        event.setCancelled(true);
        event.getWhoClicked().sendMessage("Nope, we don't do either");
    }



    //region Sun Tzu Quotes
    private final String[] quotes = {
            "The general who wins the battle makes many calculations in his temple before the battle is fought. The general who loses makes but few calculations beforehand.",
            "A leader leads by example not by force.",
            "The control of a large force is the same principle as the control of a few men: it is merely a question of dividing up their numbers.",
            "The ultimate in disposing one's troops is to be without ascertainable shape. Then the most penetrating spies cannot pry in nor can the wise lay plans against you.",
            "If words of command are not clear and distinct, if orders are not thoroughly understood, the general is to blame. But if his orders ARE clear, and the soldiers nevertheless disobey, then it is the fault of their officers.",
            "Strategy without tactics is the slowest route to victory. Tactics without strategy is the noise before defeat.",
            "All warfare is based on deception.",
            "If fighting is sure to result in victory, then you must fight.",
            "One defends when his strength is inadaquate, he attacks when it is abundant.",
            "The quality of decision is like the well-timed swoop of a falcon which enables it to strike and destroy its victim.",
            "When the enemy is at ease, be able to weary him; when well fed, to starve him; when at rest, to make him move. Appear at places to which he must hasten; move swiftly where he does not expect you.",
            "If you know your enemy and you know yourself you need not fear the results of a hundred battles. If you know yourself but not the enemy for every victory gained you will also suffer a defeat. If you know neither the enemy nor yourself you will succumb in every battle.",
            "The general who advances without coveting fame and retreats without fearing disgrace, whose only thought is to protect his country and do good service for his sovereign, is the jewel of the kingdom.",
            "For to win one hundred victories in one hundred battles is not the acme of skill. To subdue the enemy without fighting is the acme of skill.",
            "What the ancients called a clever fighter is one who not only wins, but excels in winning with ease.",
            "To a surrounded enemy, you must leave a way of escape.",
            "To know your Enemy, you must become your Enemy.",
            "Thus, what is of supreme importance in war is to attack the enemy's strategy.",
            "A leader leads by example, not force.",
            "Too frequent rewards indicate that the general is at the end of his resources; too frequent punishments that he is in acute distress.",
            "Pretend inferiority and encourage his arrogance.",
            "All men can see these tactics whereby I conquer, but what none can see is the strategy out of which victory is evolved.",
            "If we do not wish to fight, we can prevent the enemy from engaging us even though the lines of our encampment be merely traced out on the ground. All we need to do is to throw something odd and unaccountable in his way.",
            "A military operation involves deception. Even though you are competent, appear to be incompetent. Though effective, appear to be ineffective.",
            "Victorious warriors win first and then go to war, while defeated warriors go to war first and then seek to win.",
            "The best victory is when the opponent surrenders of its own accord before there are any actual hostilities... It is best to win without fighting.",
            "Opportunities multiply as they are seized.",
            "Speed is the essence of war. Take advantage of the enemy's unpreparedness; travel by unexpected routes and strike him where he has taken no precautions.",
            "If your opponent is of choleric temperament, seek to irritate him.",
            "Management of many is the same as management of few. It is a matter of organization.",
            "The good fighters of old first put themselves beyond the possibility of defeat, and then waited for an opportunity of defeating the enemy.",
            "Build your opponent a golden bridge to retreat across.",
            "Swift as the wind. Quiet as the forest. Conquer like the fire. Steady as the mountain.",
            "It is essential to seek out enemy agents who have come to conduct espionage against you and to bribe them to serve you. Give them instructions and care for them. Thus doubled agents are recruited and used.",
            "Now the reason the enlightened prince and the wise general conquer the enemy whenever they move and their achievements surpass those of ordinary men is foreknowledge.",
            "And therefore those skilled in war bring the enemy to the field of battle and are not brought there by him.",
            "There is no instance of a nation benefitting from prolonged warfare.",
            "When able to attack, we must seem unable; when using our forces, we must seem inactive; when we are near, we must make the enemy believe we are far away; when far away, we must make him believe we are near.",
            "When torrential water tosses boulders, it is because of its momentum. When the strike of a hawk breaks the body of its prey, it is because of timing.",
            "Secret operations are essential in war; upon them the army relies to make its every move.",
            "It is said that if you know your enemies and know yourself, you will not be imperilled in a hundred battles; if you do not know your enemies but do know yourself, you will win one and lose one; if you do not know your enemies nor yourself, you will be imperilled in every single battle.",
            "He who knows when he can fight and when he cannot will be victorious.",
            "Subtle and insubstantial, the expert leaves no trace; divinely mysterious, he is inaudible. Thus he is master of his enemy's fate.",
            "A skilled commander seeks victory from the situation and does not demand it of his subordinates."
    };
    //endregion
}
