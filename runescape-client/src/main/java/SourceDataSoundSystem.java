import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
@Implements("SourceDataSoundSystem")
public class SourceDataSoundSystem extends AbstractSoundSystem {
   @ObfuscatedName("e")
   AudioFormat field659;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 864442119
   )
   @Export("size")
   int size;
   @ObfuscatedName("n")
   @Export("source")
   SourceDataLine source;
   @ObfuscatedName("y")
   @Export("bytes")
   byte[] bytes;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-784678513"
   )
   protected void vmethod2051() {
      this.source.flush();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "28"
   )
   @Export("close")
   protected void close() {
      if(this.source != null) {
         this.source.close();
         this.source = null;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-112"
   )
   @Export("size")
   protected int size() {
      return this.size - (this.source.available() >> (class25.highMemory?2:1));
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1775773269"
   )
   @Export("create")
   protected void create(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field659, var1 << (class25.highMemory?2:1));
         this.source = (SourceDataLine)AudioSystem.getLine(var2);
         this.source.open();
         this.source.start();
         this.size = var1;
      } catch (LineUnavailableException var5) {
         int var4 = (var1 >>> 1 & 1431655765) + (var1 & 1431655765);
         var4 = (var4 >>> 2 & 858993459) + (var4 & 858993459);
         var4 = (var4 >>> 4) + var4 & 252645135;
         var4 += var4 >>> 8;
         var4 += var4 >>> 16;
         int var3 = var4 & 255;
         if(var3 != 1) {
            this.create(class14.method81(var1));
         } else {
            this.source = null;
            throw var5;
         }
      }
   }

   @ObfuscatedName("y")
   @Export("write")
   protected void write() {
      int var1 = 256;
      if(class25.highMemory) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.samples[var2];
         if((var3 + 8388608 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.bytes[var2 * 2] = (byte)(var3 >> 8);
         this.bytes[var2 * 2 + 1] = (byte)(var3 >> 16);
      }

      this.source.write(this.bytes, 0, var1 << 1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "59"
   )
   protected void vmethod2046() {
      this.field659 = new AudioFormat((float)AbstractSoundSystem.sampleRate, 16, class25.highMemory?2:1, true, false);
      this.bytes = new byte[256 << (class25.highMemory?2:1)];
   }
}
