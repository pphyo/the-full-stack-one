package tech.codoverse.enumeration;

public final class Season extends Enum {
   public static final Season WINTER = new Season("WINTER", 0);
   public static final Season SPRING = new Season("SPRING", 1);
   public static final Season SUMMER = new Season("SUMMER", 2);
   public static final Season FALL = new Season("FALL", 3);
   // $FF: synthetic field
   private static final Season[] $VALUES = $values();

   public static Season[] values() {
      return (Season[])$VALUES.clone();
   }

   public static Season valueOf(String var0) {
      return (Season)Enum.valueOf(Season.class, var0);
   }

   private Season(String var1, int var2) {
      super(var1, var2);
   }

   // $FF: synthetic method
   private static Season[] $values() {
      return new Season[]{WINTER, SPRING, SUMMER, FALL};
   }
}
