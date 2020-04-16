package com.example.myapplication200122;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;
import org.litepal.exceptions.DataSupportException;
import org.litepal.tablemanager.Connector;

import java.util.List;

/**
 * @author LiuSaiSai
 * @description: 开源 库：https://github.com/LitePalFramework/LitePal#latest-downloads
 * @date :2020/03/06 12:44
 */
public class LitePalTest extends AppCompatActivity implements View.OnClickListener {

    private Book book;
    private TextView textLiteData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lite_pal_test);

        Button createLiteData = findViewById(R.id.create_lite_data_button);
        Button addLiteData = findViewById(R.id.add_lite_data);
        Button updateLiteData = findViewById(R.id.update_lite_data);
        Button deleteLiteData = findViewById(R.id.delete_lite_data);
        Button queryLiteData = findViewById(R.id.query_lite_data);
        textLiteData = findViewById(R.id.text_lite_data_base);

        createLiteData.setOnClickListener(this);
        addLiteData.setOnClickListener(this);
        updateLiteData.setOnClickListener(this);
        deleteLiteData.setOnClickListener(this);
        queryLiteData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.create_lite_data_button:
                Connector.getDatabase();
                break;
            case R.id.add_lite_data:
                book = new Book();
                book.setName("第一行代码");
                book.setAuthor("郭霖");
                book.setPress("人民邮电出版社");
                book.setPages(553);
                book.setPrice(79);
                book.save();

                Book book1 = new Book();
                book1.setName("第二行代码");
                book1.setAuthor("郭2霖");
                book1.setPress("人民2邮电出版社");
                book1.setPages(153);
                book1.setPrice(79);
                book1.save();

                Book book2 = new Book();
                book2.setName("第一行代码");
                book2.setAuthor("郭3霖");
                book2.setPress("人民3邮电出版社");
                book2.setPages(253);
                book2.setPrice(79);
                book2.save();

                Book book3 = new Book();
                book3.setName("第一行代码");
                book3.setAuthor("郭4霖");
                book3.setPress("人民4邮电出版社");
                book3.setPages(353);
                book3.setPrice(79);
                book3.save();

                Book book4 = new Book();
                book4.setName("第一行代码");
                book4.setAuthor("郭5霖");
                book4.setPress("人民5邮电出版社");
                book4.setPages(453);
                book4.setPrice(79);
                book4.save();

                Book book5 = new Book();
                book5.setName("第一行代码");
                book5.setAuthor("郭6霖");
                book5.setPress("人民6邮电出版社");
                book5.setPages(553);
                book5.setPrice(79);
                book5.save();

                Book book6 = new Book();
                book6.setName("第一行代码");
                book6.setAuthor("郭7霖");
                book6.setPress("人民7邮电出版社");
                book6.setPages(653);
                book6.setPrice(79);
                book6.save();

                Book book7 = new Book();
                book7.setName("第一行代码");
                book7.setAuthor("郭0霖");
                book7.setPress("人民0邮电出版社");
                book7.setPages(53);
                book7.setPrice(79);
                book7.save();

                Book book8 = new Book();
                book8.setName("第一行代码");
                book8.setAuthor("郭8霖");
                book8.setPress("人民8邮电出版社");
                book8.setPages(753);
                book8.setPrice(79);
                book8.save();

                Book book9 = new Book();
                book9.setName("第一行代码");
                book9.setAuthor("郭9霖");
                book9.setPress("人民9邮电出版社");
                book9.setPages(853);
                book9.setPrice(79);
                book9.save();

                Book book10 = new Book();
                book10.setName("第一行代码");
                book10.setAuthor("郭霖霖");
                book10.setPress("人民邮电电出版社");
                book10.setPages(553);
                book10.setPrice(79);
                book10.save();

                Book book11 = new Book();
                book11.setName("第一行代码");
                book11.setAuthor("郭小霖");
                book11.setPress("人民邮小电出版社");
                book11.setPages(523);
                book11.setPrice(79);
                book11.save();

                break;
            case R.id.update_lite_data:
                /**
                 * 更新数据方法 一
                 */
                book = new Book();
                book.setName("皮囊");
                book.setAuthor("蔡崇达");
                book.setPress("人民邮电出版社");
                book.setPages(199);
                book.setPrice(48.8);
                book.save();
                book.setPages(218);
                book.save();
                /**
                 * 更新数据 方法 二
                 * 当你想把 数据 更新成 其默认值时；如 book.setPrice(0.0);是 × 的！
                 * 应该用 book.setToDefault("price")
                 */
                book = new Book();
                book.setPrice(49.9);
                book.setAuthor("郭霖大神");
                book.updateAll("name = ? and press = ?", "第一行代码", "人民邮电出版社");
                break;
            case R.id.delete_lite_data:
                /**
                 * Deletes the record in the database by id.<br>
                 * The data in other tables which is referenced with the record will be
                 * removed too.
                 *
                 * <pre>
                 * LitePal.delete(Person.class, 1);
                 * </pre>
                 *
                 * This means that the record 1 in person table will be removed.
                 *
                 * @param modelClass
                 *            Which table to delete from by class.
                 * @param id
                 *            Which record to delete.
                 * @return The number of rows affected. Including cascade delete rows.
                 *
                 * public static int delete (Class < ? > modelClass,long id){
                 * return Operator.delete(modelClass, id);
                 * }
                 */
                LitePal.delete(Book.class, 3);

                break;
            case R.id.query_lite_data:
                /**
                 * 查询方法
                 * .findAll() 返回只是一个 Book 类型的 List 集合；遍历所有对象
                 * >>> List<Book> books = LitePal.findAll(Book.class);
                 * .findFirst(Book.class); Book firstBook =  LitePal.findFirst(Book.class);
                 * .findLast(Book.class);
                 * .select() 指定查询哪几行：List<Book> books = LitePal.select("name","author").find(Book.class);
                 * .where() 指定查询的约束条件：List<Book> books = LitePal.where("pages > ?","400").find(Book.class);
                 * .order() 指定结果的排序方式desc 是降序，asc是升序：List<Book> books = LitePal.order("price desc").find(Book.class);
                 * .limit() 指定查询数据结果 的数量：List<Book> books = LitePal.limit(3).find(Book.class);
                 * .offset() 表示查询结果的偏移量；如查询2 3 4 条数据：List<Book> books = LitePal.limit(3).offset(1).find(Book.class);
                 * 还可以调用 原生查询：Cursor cursor = LitePal.findBySQL("select * from Book where pages > ? and price < >","400","20");
                 * 或者任意的连缀组合
                 */
                List<Book> books = LitePal.select("name", "author", "pages")
                        .where("pages > ?", "300")
                        .order("pages")
                        .limit(15)
                        .offset(10)
                        .find(Book.class);
                for (Book book : books) {
                    String name = book.getName();
                    String author = book.getAuthor();
                    int pages = book.getPages();
                    double price = book.getPrice();

                    textLiteData.append(name + "｜" + author + "｜" + pages + "｜" + price + "\n");
                }
                break;
            default:
                break;
        }
    }
}
