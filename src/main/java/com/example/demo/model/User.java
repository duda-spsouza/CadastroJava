package com.example.demo.model;

	public class User {
		 
	    private Long userId;
	    private String userNome;
	    private String userCredito;
	    private String userRisco;
	    private String userTaxa;
	 
	    public User() {
	 
	    }
	 
	    public User(UserForm userForm) {
	        this.userId = userForm.getUserId();
	        this.userNome = userForm.getUserNome();
	        this.userCredito = userForm.getUserCredito();
	        this.userRisco = userForm.getUserRisco();
	        this.userTaxa = userForm.getUserTaxa();
	    }

		public User(Long userId, String userNome, String userCredito, String userRisco, String userTaxa) {
			this.userId = userId;
			this.userNome = userNome;
			this.userCredito = userCredito;
			this.userRisco = userRisco;
			this.userTaxa = userTaxa;
		}

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public String getUserNome() {
			return userNome;
		}

		public void setUserNome(String userNome) {
			this.userNome = userNome;
		}

		public String getUserCredito() {
			return userCredito;
		}

		public void setUserCredito(String userCredito) {
			this.userCredito = userCredito;
		}

		public String getUserRisco() {
			return userRisco;
		}

		public void setUserRisco(String userRisco) {
			this.userRisco = userRisco;
		}

		public String getUserTaxa() {
			return userTaxa;
		}

		public void setUserTaxa(String userTaxa) {
			this.userTaxa = userTaxa;
		}
	 
	    	 
	}
