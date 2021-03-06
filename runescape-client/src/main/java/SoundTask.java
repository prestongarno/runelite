import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
@Implements("SoundTask")
public class SoundTask implements Runnable {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "[Ldw;"
   )
   @Export("systems")
   volatile AbstractSoundSystem[] systems;

   SoundTask() {
      this.systems = new AbstractSoundSystem[2];
   }

   public void run() {
      try {
         for(int var1 = 0; var1 < 2; ++var1) {
            AbstractSoundSystem var2 = this.systems[var1];
            if(var2 != null) {
               var2.method2039();
            }
         }
      } catch (Exception var4) {
         NPC.method1722((String)null, var4);
      }

   }
}
