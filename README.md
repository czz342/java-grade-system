# 学生成绩管理系统

这是一个用于 Git 多人协作实验的 Java 示例。项目不依赖第三方库，使用 JDK 8 及以上版本即可编译。

## 功能

- 保存学生基本信息。
- 保存课程成绩。
- 计算平均分。
- 根据平均分划分成绩等级。
- 在控制台输出成绩单。

## 目录结构

```text
java-grade-system/
├─ src/main/java/cn/edu/demo/grade/
│  ├─ Course.java
│  ├─ GradeBook.java
│  ├─ GradeService.java
│  ├─ Main.java
│  └─ Student.java
└─ .gitignore
```

## 编译和运行

在项目根目录执行：

```powershell
New-Item -ItemType Directory -Force out | Out-Null
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse -Filter *.java).FullName
java -cp out cn.edu.demo.grade.Main
```

所有源代码均使用 UTF-8 编码。
