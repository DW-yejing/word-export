package person.yejing.wordtemplate.poitl;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.MiniTableRenderData;
import com.deepoove.poi.data.RowRenderData;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileOutputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
class PoitlWordExportTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void SimpleWordExport() throws Exception{
        Map<String, Object> datas = new HashMap<String, Object>();
        RowRenderData row1 = RowRenderData.build("来源预算合计", "100", "支出预算合计", "100", "0.0", "100");
        RowRenderData row2 = RowRenderData.build("一、甲方拨款", "100", "一、直接费", "74.824", "0.0", "74.824");
        MiniTableRenderData miniTableRenderData = new MiniTableRenderData(Arrays.asList(row1, row2), 8.00f);
        datas.put("maplist", miniTableRenderData);
        datas.put("budget", "预算");
        Resource resource = applicationContext.getResource("poitl.docx");
        String filePath = resource.getFile().getAbsolutePath();
        XWPFTemplate template = XWPFTemplate.compile(filePath).render(datas);

        FileOutputStream out = new FileOutputStream("D:/excel/poitl.docx");
        template.write(out);
        out.flush();
        out.close();
        template.close();
    }

    @Test
    public void test() throws Exception{
        Resource resource = applicationContext.getResource("poitl.docx");
        String filePath = resource.getFile().getAbsolutePath();
        System.out.println(filePath);
    }

}