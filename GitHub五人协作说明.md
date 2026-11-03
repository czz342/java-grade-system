# GitHub 五人小组协作说明

## 成员分工

- 同学甲：创建 GitHub 仓库，推送初始代码，并邀请其他四人加入仓库。
- 同学乙：克隆仓库，修改 `GradeService.java`，比较差异后提交并推送。
- 同学丙：克隆或更新仓库，修改 `Student.java`，拉取同学乙的提交后推送。
- 同学丁：拉取最新版本，使用 `git log`、`git show` 和 `git diff` 检查乙、丙的修改。
- 同学戊：独立克隆最新版本，比较远程与本地差异，并完成一次 `pull` 操作。

## 一、同学甲上传到 GitHub

先在 GitHub 网页创建一个空仓库，例如 `java-grade-system`。不要勾选自动生成 README、`.gitignore` 或许可证，因为本地已经有对应文件。

在 `D:\GitTeamPractice\student-a\java-grade-system` 中执行下面的命令，并把仓库地址换成自己的实际地址：

```powershell
cd D:\GitTeamPractice\student-a\java-grade-system
git remote rename origin local-lab
git remote add origin https://github.com/你的GitHub用户名/java-grade-system.git
git push -u origin main
git remote -v
```

接着在 GitHub 仓库的 **Settings → Collaborators** 中依次添加同学乙、丙、丁、戊。四人需要登录 GitHub 并接受邀请。如果老师需要检查，可以邀请老师，或者把仓库设为 Public。

> 如果本组使用 Fork 模式，则每人先 Fork，再克隆自己的 Fork，通过 Pull Request 提交修改。直接邀请协作者更适合老师要求的“克隆—修改—push”流程。

## 二、所有人配置自己的 Git 身份

每名同学使用自己的姓名和 GitHub 邮箱。不要把五个人都配置成同学甲的身份。

```powershell
git config user.name "你的姓名或GitHub用户名"
git config user.email "你的GitHub邮箱"
```

如果不想公开真实邮箱，可以使用 GitHub 提供的 `noreply` 邮箱。身份配置只影响本仓库，不会破坏其他项目。

## 三、同学乙修改并推送

```powershell
cd D:\GitTeamPractice
New-Item -ItemType Directory -Force student-b | Out-Null
git clone https://github.com/你的GitHub用户名/java-grade-system.git student-b\java-grade-system
cd D:\GitTeamPractice\student-b\java-grade-system
git config user.name "同学乙"
git config user.email "同学乙的GitHub邮箱"
```

修改 `src/main/java/cn/edu/demo/grade/GradeService.java`，例如把成绩等级扩展成五档，然后执行：

```powershell
git status
git diff
git add src/main/java/cn/edu/demo/grade/GradeService.java
git commit -m "同学乙：完善成绩等级规则"
git pull --rebase origin main
git push origin main
```

## 四、同学丙修改并推送

```powershell
cd D:\GitTeamPractice
New-Item -ItemType Directory -Force student-c | Out-Null
git clone https://github.com/你的GitHub用户名/java-grade-system.git student-c\java-grade-system
cd D:\GitTeamPractice\student-c\java-grade-system
git config user.name "同学丙"
git config user.email "同学丙的GitHub邮箱"
```

修改 `src/main/java/cn/edu/demo/grade/Student.java`，例如新增 `isPassed()` 方法，然后执行：

```powershell
git status
git diff
git add src/main/java/cn/edu/demo/grade/Student.java
git commit -m "同学丙：增加及格状态判断"
git pull --rebase origin main
git push origin main
```

同学乙和同学丙修改不同文件，可以降低实验时发生冲突的概率。每次推送前都先执行 `git pull --rebase origin main`，可以减少“远程包含本地没有的提交”这类推送失败。

## 五、同学丁比较差异

```powershell
cd D:\GitTeamPractice
New-Item -ItemType Directory -Force student-d | Out-Null
git clone https://github.com/你的GitHub用户名/java-grade-system.git student-d\java-grade-system
cd D:\GitTeamPractice\student-d\java-grade-system
git log --oneline --decorate --graph --all
git show --stat HEAD
git diff HEAD~2..HEAD
git pull --rebase origin main
git status
```

## 六、同学戊独立克隆并比较

```powershell
cd D:\GitTeamPractice
New-Item -ItemType Directory -Force student-e | Out-Null
git clone https://github.com/你的GitHub用户名/java-grade-system.git student-e\java-grade-system
cd D:\GitTeamPractice\student-e\java-grade-system
git log --oneline --reverse
git show HEAD~1
git show HEAD
git pull --rebase origin main
git status
```

提交数量不同或提交顺序变化时，先运行 `git log --oneline` 找到提交号，再用 `git show 提交号` 或 `git diff 提交号1 提交号2` 比较，不必死记 `HEAD~1`。

## 七、实验截图建议

建议保留以下命令的结果截图：

```powershell
git status
git diff
git log --oneline --decorate --graph --all
git remote -v
git pull --rebase origin main
git show --stat 提交号
```

这些结果能够分别证明文件修改、差异比较、提交推送和远程拉取过程。
