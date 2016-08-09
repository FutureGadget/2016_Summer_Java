package entity.book;

public class BookEntity {
	private String bisbn;
	private String btitle;
	private String bprice;
	private String bimgurl;
	private String bauthor;
	public BookEntity(String bisbn, String btitle, String bauthor, String bprice, String bimgurl) {
		setBisbn(bisbn);
		setBtitle(btitle);
		setBauthor(bauthor);
		setBprice(bprice);
		setBimgurl(bimgurl);
	}
	public String getBisbn() {
		return bisbn;
	}
	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBprice() {
		return bprice;
	}
	public void setBprice(String bprice) {
		this.bprice = bprice;
	}
	public String getBimgurl() {
		return bimgurl;
	}
	public void setBimgurl(String bimgurl) {
		this.bimgurl = bimgurl;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	
}
