package cn.zz.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.zz.domain.Comment;
import cn.zz.domain.News;
import cn.zz.domain.User;

public interface NewsDao
{

    // 添加一条评价到新闻
    public abstract void addComment(Comment c);

    // 查找新闻
    public abstract List<News> pagingNewsByDate(int offset, int length);
    //查找新闻总数
    public int findNewsSum();
    //查找新闻
    public News findNewsById(int id);
//    //点赞
//    public void goodNews(User u,News n);
//    //收藏
//    public void collect(User u,News n);

    public abstract Set<Comment> findCommentByNewsId(int id);

    public abstract List<News> pagingNewsByDate(int offset, int length,
            Map<String, String> conMap);

}