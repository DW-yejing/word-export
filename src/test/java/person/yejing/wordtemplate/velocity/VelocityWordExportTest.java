package person.yejing.wordtemplate.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.context.Context;
import org.apache.velocity.runtime.RuntimeInstance;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;
import person.yejing.wordtemplate.model.DataFrame;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@RunWith(SpringRunner.class)
@SpringBootTest
class VelocityWordExportTest {
    @Autowired
    private ApplicationContext applicationContext;

    static{
        Properties p = new Properties();
        // 设置输入输出编码类型。和这次说的解决的问题无关
        p.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
        p.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
        //文件缓存
        p.setProperty(Velocity.FILE_RESOURCE_LOADER_CACHE, "false");
        // 这里加载类路径里的模板而不是文件系统路径里的模板
       p.setProperty("file.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(p);
    }

    @Test
    void simpleWordExport() throws Exception {
        List<Map<String, Object>> mapList = DataFrame.funds;
        Resource resource = applicationContext.getResource("velocity.xml");
        Template template = Velocity.getTemplate("velocity.xml");
        Writer writer = new FileWriter(new File("D:/excel/velocity.doc"));
        Context context = new VelocityContext();
        context.put("mapList", mapList);
        template.merge(context, writer);
        writer.flush();
        writer.close();
    }

    @Test
    public void test(){
        Template template = Velocity.getTemplate("velocity.xml");

        System.out.println(template);
    }
}