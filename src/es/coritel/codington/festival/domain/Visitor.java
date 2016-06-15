package es.coritel.codington.festival.domain;

import es.coritel.codington.festival.exceptions.DomainException;
import es.coritel.codington.festival.utils.Validator;

/**
 *	POJO for VISITOR CLASS
 */
public class Visitor extends People {
		private static final int minLengthUserName = 6;
		private static final int maxLengthUserName = 12;
		private static final int minLengthPassword = 6;
		private static final int maxLengthPassword = 15;
		
		//Identificador del visitante
		private int visitorId;
		
		private String userName;// Nombre de usuario utilizado en el portal web

		private String password; // Contraseña del usuario
		
		//Booleano que indica si el visitante es administrador o no
		private boolean admin;

	
		/**
		 * Constructor por defecto, crea un visitante vacio
		 */
		public Visitor(){}
		
		/**
		 * Constructor de copia, crea un objeto Vistor copiando los atributos de otro
		 */
public Visitor(Visitor visitor) {
			
			this.visitorId = visitor.visitorId;
			this.userName =visitor.userName;
			this.password =visitor.password;
			this.admin = visitor.admin;
		}

		public int getVisitorId() {
			return visitorId;
		}

		public void setVisitorId(int visitorId) {
			this.visitorId = visitorId;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			if(Validator.checkLength(minLengthUserName, maxLengthUserName, userName))
				this.userName = userName;
			else
				throw new DomainException("Invalid username");
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			if(Validator.checkLength(minLengthPassword, maxLengthPassword, password))
			this.password = password;
			else
				throw new DomainException("Invalid password");
		}

		public boolean isAdmin() {
			return admin;
		}

		public void setAdmin(boolean admin) {
			this.admin = admin;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + (admin ? 1231 : 1237);
			result = prime * result
					+ ((password == null) ? 0 : password.hashCode());
			result = prime * result
					+ ((userName == null) ? 0 : userName.hashCode());
			result = prime * result + visitorId;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			Visitor other = (Visitor) obj;
			if (admin != other.admin)
				return false;
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			if (userName == null) {
				if (other.userName != null)
					return false;
			} else if (!userName.equals(other.userName))
				return false;
			if (visitorId != other.visitorId)
				return false;
			return true;
		}
		
		
}
