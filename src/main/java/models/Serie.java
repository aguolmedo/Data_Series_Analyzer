package models;

public class Serie {
    private String seriesTitle;
    private String runtimeOfSeries;
    private String certificate;
    private String runtimeOfEpisodes;
    private String[] genre;
    private float imdbRating;
    private String overview;

    public Serie(String seriesTitle, String runtimeOfSeries, String certificate, String runtimeOfEpisodes, String[] genre, float imdbRating, String overview, String star1, String star2, String star3, String star4, int numberOfVotes) {
        this.seriesTitle = seriesTitle;
        this.runtimeOfSeries = runtimeOfSeries;
        this.certificate = certificate;
        this.runtimeOfEpisodes = runtimeOfEpisodes;
        this.genre = genre;
        this.imdbRating = imdbRating;
        this.overview = overview;
        this.star1 = star1;
        this.star2 = star2;
        this.star3 = star3;
        this.star4 = star4;
        this.numberOfVotes = numberOfVotes;
    }

    private String star1;
    private String star2;
    private String star3;
    private String star4;
    private int numberOfVotes;

    public String getSeriesTitle() {
        return seriesTitle;
    }

    public void setSeriesTitle(String seriesTitle) {
        this.seriesTitle = seriesTitle;
    }

    public String getRuntimeOfSeries() {
        return runtimeOfSeries;
    }

    public void setRuntimeOfSeries(String runtimeOfSeries) {
        this.runtimeOfSeries = runtimeOfSeries;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getRuntimeOfEpisodes() {
        return runtimeOfEpisodes;
    }

    public void setRuntimeOfEpisodes(String runtimeOfEpisodes) {
        this.runtimeOfEpisodes = runtimeOfEpisodes;
    }

    public String[] getGenre() {
        return genre;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }

    public float getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(float imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getStar1() {
        return star1;
    }

    public void setStar1(String star1) {
        this.star1 = star1;
    }

    public String getStar2() {
        return star2;
    }

    public void setStar2(String star2) {
        this.star2 = star2;
    }

    public String getStar3() {
        return star3;
    }

    public void setStar3(String star3) {
        this.star3 = star3;
    }

    public String getStar4() {
        return star4;
    }

    public void setStar4(String star4) {
        this.star4 = star4;
    }

    public int getNumberOfVotes() {
        return numberOfVotes;
    }

    public void setNumberOfVotes(int numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(seriesTitle);
        return sb.toString();
    }
}
