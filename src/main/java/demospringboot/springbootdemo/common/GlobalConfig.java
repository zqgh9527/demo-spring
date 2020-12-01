package demospringboot.springbootdemo.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: kangshuaibing
 * @Date: 2019/11/18 14:04
 * @Description:
 */
public class GlobalConfig {

    private static final Logger log = LoggerFactory.getLogger(GlobalConfig.class);
    private static String NAME = Global.getConfigName();

    /**
     * 当前对象实例
     */
    private static GlobalConfig global = null;

    /**
     * 保存全局属性值
     */
    private static Map<String, String> map = new HashMap<String, String>();

    private GlobalConfig() {
    }

    /**
     * 静态工厂方法 获取当前对象实例 多线程安全单例模式(使用双重同步锁)
     */

    public static synchronized GlobalConfig getInstance() {
        if (global == null) {
            synchronized (GlobalConfig.class) {
                if (global == null)
                    global = new GlobalConfig();
            }
        }
        return global;
    }

    /**
     * 获取配置
     */
    public static String getConfig(String key) {
        String value = map.get(key);
        if (value == null) {
            Map<?, ?> yamlMap = null;
            try {
                yamlMap = YamlUtil.loadYaml(NAME);
                value = String.valueOf(YamlUtil.getProperty(yamlMap, key));
                map.put(key, value != null ? value : "");
            } catch (FileNotFoundException e) {
                log.error("获取全局配置异常 {}", key);
            }
        }
        return value;
    }

    /**
     * 获取文件上传路径
     */
    public static String getProfile() {
        return getConfig("info.profile");
    }

    /**
     * 365服务器ip
     */
    public static String getip365() {
        return getConfig("info.ip365");
    }

    /**
     * 本地ip
     */
    public static String getiplocalhost() {
        return getConfig("info.iplocalhost");
    }

    /**
     * 参数
     */
    public static String getConfigs(String str) {
        return getConfig("info." + str);
    }

    public static String getPr() {
        return getConfig("spring.profiles.active");
    }

    /**
     * 获取用户信息路径
     */
    public static String getUserInfoPath() {
        return getConfig("buaInterface.userInfo");
    }

    /**
     * 类型get请求，orgCode  机构code，includeLocked  是否包含被锁定用户，默认值false （根据机构代号穿透查询所有用户）
     */
    public static String getOrgUser() {
        return getConfig("buaInterface.orgUser");
    }

    /**
     * 类型get请求，参数：code  机构code，rootCode  机构父code，isIncludeRoot  是否包含父code
     */
    public static String getOrgInfo() {
        return getConfig("buaInterface.orgInfo");
    }

    /**
     * 获取环境
     */
    public static String getEnv() {
        return getConfig("info.env");
    }
}
