import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1546733905
   )
   @Export("canvasWidth")
   public static int canvasWidth;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   @Export("composition")
   NPCComposition composition;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lew;",
      garbageValue = "-2113451941"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?Ignore.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && (super.poseAnimation != super.idlePoseAnimation || var1 == null)?Ignore.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method4660(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2519();
            super.field1255 = var3.modelHeight;
            if(super.graphic != -1 && super.field1209 != -1) {
               Model var4 = GameEngine.getSpotAnimType(super.graphic).method4337(super.field1209);
               if(var4 != null) {
                  var4.method2526(0, -super.field1265, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field3547 == 1) {
               var3.field1938 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "1201091864"
   )
   final void method1708(int var1, byte var2) {
      int var3 = super.pathX[0];
      int var4 = super.pathY[0];
      if(var1 == 0) {
         --var3;
         ++var4;
      }

      if(var1 == 1) {
         ++var4;
      }

      if(var1 == 2) {
         ++var3;
         ++var4;
      }

      if(var1 == 3) {
         --var3;
      }

      if(var1 == 4) {
         ++var3;
      }

      if(var1 == 5) {
         --var3;
         --var4;
      }

      if(var1 == 6) {
         --var4;
      }

      if(var1 == 7) {
         ++var3;
         --var4;
      }

      if(super.animation != -1 && Ignore.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(super.queueSize < 9) {
         ++super.queueSize;
      }

      for(int var5 = super.queueSize; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.field1262[var5] = super.field1262[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.field1262[0] = var2;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2046618582"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "-133615952"
   )
   final void method1709(int var1, int var2, boolean var3) {
      if(super.animation != -1 && Ignore.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(!var3) {
         int var4 = var1 - super.pathX[0];
         int var5 = var2 - super.pathY[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.queueSize < 9) {
               ++super.queueSize;
            }

            for(int var6 = super.queueSize; var6 > 0; --var6) {
               super.pathX[var6] = super.pathX[var6 - 1];
               super.pathY[var6] = super.pathY[var6 - 1];
               super.field1262[var6] = super.field1262[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.field1262[0] = 1;
            return;
         }
      }

      super.queueSize = 0;
      super.field1264 = 0;
      super.field1263 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.field1254 * 64 + super.pathX[0] * 128;
      super.y = super.field1254 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;B)V",
      garbageValue = "44"
   )
   public static void method1722(String var0, Throwable var1) {
      var1.printStackTrace();
   }
}
