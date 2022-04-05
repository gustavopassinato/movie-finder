package br.com.code;

public class Movie {

	private String name;
	private String year;
	private String urlImage;
	private String imdbRating;

	public Movie(String name, String year, String urlImage, String imdbRating) {
		this.name = name;
		this.year = year;
		this.urlImage = urlImage;
		this.imdbRating = imdbRating;
	}

	public String getName() {
		return name;
	}

	public String getYear() {
		return year;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public String getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}
	
	@Override
	public String toString() {
		return "[Filme: "+ this.name+", ano: "+ this.year + ", imdb Rating: "+ this.imdbRating;
	}

}
