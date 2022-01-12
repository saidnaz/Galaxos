	
	package fr.isika.cda.galaxos.viewmodel;

	import java.io.Serializable;
import java.time.LocalDate;

import fr.isika.cda.galaxos.model.Domaine;

	public class CataloguePostForm implements Serializable {

		private static final long serialVersionUID = 7869037247746806889L;

		private String search;

		private LocalDate startDate;

		private Domaine domaines;

		public CataloguePostForm() {
			super();
		}

		public CataloguePostForm(String search, LocalDate startD, Domaine domaine) {
			super();
			this.search = search;
			this.startDate = startD;
			this.domaines = domaine;
		}

		public String getSearch() {
			return search;
		}

		public void setSearch(String search) {
			this.search = search;
		}



		public Domaine getDomaine() {
			return domaines;
		}

		public void setDomaine(Domaine domaine) {
			this.domaines = domaine;
		}


}
