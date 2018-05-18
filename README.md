# HiPermission
权限管理
## 导入
1. 在build.gradle添加如下代码：<br>
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
2. 添加依赖关系
```
dependencies {
	compile 'com.github.uguker:HiPermission:1.2.4'
}
```
# 使用方法
```
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Permission> permissions = new ArrayList<>();
                permissions.add(Permission.PHONE);
                permissions.add(Permission.CALENDAR);
                permissions.add(Permission.STORAGE);
                permissions.add(Permission.CAMERA);
                permissions.add(Permission.MICROPHONE);
                permissions.add(Permission.SENSORS);
                permissions.add(Permission.SMS);
                permissions.add(Permission.LOCATION);
                permissions.add(Permission.CONTACTS);

                // 需要什么权限增加什么权限
                HiPermission.with(this)
                        .permissions(
                                Permission.PHONE,
                                Permission.CALENDAR,
                                Permission.CAMERA)
                        .permissions(permissions)   // 两种方式都可以
                        .onGranted(new HiPermission.OnGrantedListener() {
                            @Override
                            public void onGranted(List<Permission> permissions) {

                            }
                        })
                        .onDenied(new HiPermission.OnDeniedListener() {
                            @Override
                            public void onDenied(List<Permission> permissions) {

                            }
                        })
                        .onRationale(new HiPermission.OnRationaleListener() {
                            @Override
                            public void onRationale(List<Permission> permissions) {

                            }
                        })
                        .request();
    }

```
