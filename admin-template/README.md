> 如果maven打包失败，`'version' contains an expression but should be a constant.` 执行如下命令
```bash
mvn -N versions:update-child-modules
```