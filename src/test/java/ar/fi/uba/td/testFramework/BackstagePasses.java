package ar.fi.uba.td.testFramework;

public class BackstagePasses {

    private String concertName;
    private int sellIn;
    private int quality;

    public BackstagePasses(String concertName, int sellIn, int quality) {
	this.concertName = concertName;
    }

    @Override
    public boolean equals(Object other) {
	String otherPassesConcertName = ((BackstagePasses) other)
		.getConcertName();
	return this.concertName.equals(otherPassesConcertName);
    }

    public String getConcertName() {
	return concertName;
    }

    public void setConcertName(String concertName) {
	this.concertName = concertName;
    }

    public int getSellIn() {
	return sellIn;
    }

    public void setSellIn(int sellIn) {
	this.sellIn = sellIn;
    }

    public int getQuality() {
	return quality;
    }

    public void setQuality(int quality) {
	this.quality = quality;
    }

}
