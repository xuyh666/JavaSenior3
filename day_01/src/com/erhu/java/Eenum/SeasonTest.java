package com.erhu.java.Eenum;

class Season{
    private final String seasonName;
    private final String seasonDesc;

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Season season = (Season) o;

        if (seasonName != null ? !seasonName.equals(season.seasonName) : season.seasonName != null) return false;
        return seasonDesc != null ? seasonDesc.equals(season.seasonDesc) : season.seasonDesc == null;
    }*/

    @Override
    public int hashCode() {
        int result = seasonName != null ? seasonName.hashCode() : 0;
        result = 31 * result + (seasonDesc != null ? seasonDesc.hashCode() : 0);
        return result;
    }

    private Season(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");
    public static final Season AUTUMN = new Season("秋天","秋高气爽");
    public static final Season WINTER = new Season("冬天","冬风凛冽");

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}

public class SeasonTest {
    private String s;

    public SeasonTest() {
    }

    public SeasonTest(String s) {
        this.s = s;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeasonTest that = (SeasonTest) o;

        return s != null ? s.equals(that.s) : that.s == null;
    }*/

    @Override
    public int hashCode() {
        return s != null ? s.hashCode() : 0;
    }

    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
    }
}
