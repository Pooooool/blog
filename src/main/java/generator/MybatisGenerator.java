package generator;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MybatisGenerator {
	public static void main(String[] args) throws Exception {
		String today = "2020-6-5";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date now = sdf.parse(today);
        Date d = new Date();

        if (d.getTime() > now.getTime() + 1000 * 60 * 60 * 24) {
            System.err.println("������������δ�ɳɹ����С�����������");
            System.err.println("������������δ�ɳɹ����С�����������");
            System.err.println("����������ƻ����ã�Ӧ��ֻ����һ�Σ��������Ҫ�����У���Ҫ�޸�today����Ϊ���죬��:" + sdf.format(new Date()));
            return;
        }

        if (false)
            return;
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        InputStream is = MybatisGenerator.class.getClassLoader().getResource("generator.xml").openStream();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

        System.out.println("���ɴ���ɹ���ֻ��ִ��һ�Σ��Ժ�ִ�лḲ�ǵ�mapper,pojo,xml ���ļ��������޸�");
    }

}

