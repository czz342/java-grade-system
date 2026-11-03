# 五人 Git 协作操作说明

仓库地址：`https://github.com/czz342/java-grade-system.git`

开始前，同学甲需要在 GitHub 的 **Settings → Collaborators** 中邀请另外四人，大家登录 GitHub 接受邀请。

## 每名同学先执行一次

在桌面或 D 盘打开 PowerShell，执行：

```powershell
git clone https://github.com/czz342/java-grade-system.git
cd java-grade-system
git config user.name "同学乙"
git config user.email "你的GitHub邮箱"
```

把“同学乙”和邮箱换成自己的信息。以后打开项目，只需要：

```powershell
cd java-grade-system
```

## 修改分工

| 同学 | 负责文件 | 修改示例 |
|---|---|---|
| 甲 | 全部 Java 文件 | 初始化项目、推送代码 |
| 乙 | `GradeService.java` | 完善成绩等级 |
| 丙 | `Student.java` | 添加 `isPassed()` 方法 |
| 丁 | 不修改 | 拉取并比较乙、丙的提交 |
| 戊 | 不修改 | 独立克隆、拉取并比较差异 |

乙、丙不要修改同一个文件的同一段内容，可以减少冲突。

## 同学乙修改并提交

修改 `src/main/java/cn/edu/demo/grade/GradeService.java` 后执行：

```powershell
git status
git diff
git add .
git commit -m "乙：完善成绩等级"
git pull --rebase
git push
```

## 同学丙修改并提交

在 `src/main/java/cn/edu/demo/grade/Student.java` 中增加 `isPassed()` 方法，然后执行：

```powershell
git status
git diff
git add .
git commit -m "丙：增加及格判断"
git pull --rebase
git push
```

`git diff` 用来比较修改前后的差异。推送前执行 `git pull --rebase`，可以取得乙或丙已经推送到 GitHub 的最新提交。

## 同学甲以后更新

```powershell
git status
git add .
git commit -m "甲：更新项目"
git pull --rebase
git push
```

## 同学丁拉取并比较

```powershell
git pull
git log --oneline
git diff HEAD~2 HEAD
```

`HEAD~2 HEAD` 表示比较最近两次提交。提交数量不同时，先执行 `git log --oneline` 找到提交号，再执行：

```powershell
git diff 提交号1 提交号2
```

## 同学戊独立克隆并比较

```powershell
git clone https://github.com/czz342/java-grade-system.git
cd java-grade-system
git log --oneline
git show HEAD
git pull --rebase
```

## 实验截图

建议每人至少保留以下三个命令的结果：

```powershell
git status
git log --oneline
git remote -v
```

乙、丙再截一张 `git diff` 和 `git push`；丁、戊再截一张 `git pull` 和 `git diff`。
