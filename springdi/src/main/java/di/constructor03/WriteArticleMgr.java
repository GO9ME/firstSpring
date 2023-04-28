package di.constructor03;

public class WriteArticleMgr implements IWriteArticleMgr {
	private IArticleDAO articleDAO;
	
	public WriteArticleMgr() {
		// TODO Auto-generated constructor stub
	}
	
	public WriteArticleMgr(IArticleDAO articleDAO) {
		super();
		this.articleDAO = articleDAO;
		System.out.println("write article 생성자");
	}


	@Override
	public void write(ArticleDTO article) {
		// TODO Auto-generated method stub
		articleDAO.insert(article);

	}

}
