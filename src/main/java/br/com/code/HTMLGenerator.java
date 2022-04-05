package br.com.code;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class HTMLGenerator {

	private PrintWriter printWriter;

	private String head = """
			<head>
				<meta charset=\"utf-8\">
				<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
				<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\"
					+ "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">
			</head>
			""";

	private String divTemplate = """
			<div class=\"card text-white bg-dark mb-3\" style=\"max-width: 18rem;\">
				<h4 class=\"card-header\">%s</h4>
				<div class=\"card-body\">
					<img class=\"card-img\" src=\"%s\" alt=\"%s\">
					<p class=\"card-text mt-2\">Nota: %s - Ano: %s</p>
				</div>
			</div>
			""";

	public HTMLGenerator(PrintWriter printWriter) {
		this.printWriter = printWriter;
	}

	public boolean generate(List<Movie> movieList) {
		BufferedWriter writer = new BufferedWriter(this.printWriter);
		
		try {

			writer.append("<html>");
			
			writer.append(this.head);
			writer.append("<body>");
			movieList.forEach(movie -> {
				try {
					writer.append(String.format(divTemplate, movie.getName(), movie.getUrlImage(), movie.getName(), movie.getImdbRating(), movie.getYear()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			writer.append("</body>");
			writer.append("</html>");
			writer.close();
			return true;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
