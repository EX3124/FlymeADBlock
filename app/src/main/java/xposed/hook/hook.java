package xposed.hook;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class hook implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.setStaticObjectField(android.os.Build.class, "PRODUCT", "meizu_18_CN");
        XposedHelpers.setStaticObjectField(android.os.Build.class, "DEVICE", "meizu18");
        XposedHelpers.setStaticObjectField(android.os.Build.class, "MODEL", "MEIZU 18");
        XposedHelpers.setStaticObjectField(XposedHelpers.findClass("android.os.BuildExt", lpparam.classLoader), "MZ_MODEL", "M1810");

        XposedHelpers.findAndHookMethod("android.os.SystemProperties", lpparam.classLoader, "get", String.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                if (param.args[0].equals("ro.product.name"))
                    param.setResult("meizu_18_CN");
                if (param.args[0].equals("ro.product.device"))
                    param.setResult("meizu18");
                if (param.args[0].equals("ro.product.model"))
                    param.setResult("MEIZU 18");
                if (param.args[0].equals("ro.meizu.product.model") || param.args[0].equals("ro.vendor.meizu.product.model"))
                    param.setResult("M1810");
                if (param.args[0].equals("ro.product.flyme.model") || param.args[0].equals("ro.vendor.product.flyme.model"))
                    param.setResult("M2181");
                if (param.args[0].equals("ro.meizu.hardware.version"))
                    param.setResult("0x18101001");
            }
        });
        XposedHelpers.findAndHookMethod("android.os.SystemProperties", lpparam.classLoader, "get", String.class, String.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                if (param.args[0].equals("ro.product.name"))
                    param.setResult("meizu_18_CN");
                if (param.args[0].equals("ro.product.device"))
                    param.setResult("meizu18");
                if (param.args[0].equals("ro.product.model"))
                    param.setResult("MEIZU 18");
                if (param.args[0].equals("ro.meizu.product.model") || param.args[0].equals("ro.vendor.meizu.product.model"))
                    param.setResult("M1810");
                if (param.args[0].equals("ro.product.flyme.model") || param.args[0].equals("ro.vendor.product.flyme.model"))
                    param.setResult("M2181");
                if (param.args[0].equals("ro.meizu.hardware.version"))
                    param.setResult("0x18101001");
            }
        });
    }
}
