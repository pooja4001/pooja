package com.capgemini.backgroundverification.entity;
/*import javax.persistence.*;

@Entity
@Table(name="model_document")
public class FileModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String docName;
    
    @Column(name = "doctype")
	private String doctype;
	

    @Column
    @Lob
    private byte[] file;

    public FileModel(String docName, String docType, byte[] file) {
		// TODO Auto-generated constructor stub
    	this.docName=docName;
    	this.doctype=docType;
    	this.file=file;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public byte[] getFile() {
        return file;
    }

}*/

	import javax.persistence.CascadeType;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.Lob;
	import javax.persistence.OneToOne;
	import javax.persistence.Table;



	@Entity
	@Table(name="FileModel")
	public class FileModel {
		@Id
		@GeneratedValue
	    @Column(name = "id")
	    private Long id;
		
	    @Column(name = "name")
		private String name;
	    
	    @Column(name = "mimetype")
		private String mimetype;
		
		@Lob
	    @Column(name="pic")
	    private byte[] pic;
		
		public FileModel()
		{
			
		}
		public FileModel(String name, String mimetype, byte[] pic){
			this.name = name;
			this.mimetype = mimetype;
			this.pic = pic;
		}
		
		public Long getId(){
			return this.id;
		}
		
		public void setId(Long id){
			this.id = id;
		}
		
		public String getName(){
			return this.name;
		}
		
		public void setName(String name){
			this.name = name;
		}
		
		public String getMimetype(){
			return this.mimetype;
		}
		
		public void setMimetype(String mimetype){
			this.mimetype = mimetype;
		}
		
		public byte[] getPic(){
			return this.pic;
		}
		
		public void setPic(byte[] pic){
			this.pic = pic;
		}
		}

