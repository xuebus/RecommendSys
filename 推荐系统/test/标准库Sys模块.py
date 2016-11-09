import sys

print("script name is %s" % sys.argv[0])# 使用sys.argv[0]采集脚本名称
# script name is /home/wwy/IdeaProjects/推荐系统/test/test.py

print("path has ", len(sys.path))

print(sys.modules.keys()) #使用sys模块查找已导入的模块

print(sys.platform) #当前平台



#当我们在 Python 中打印对象调用 print obj 时候，
# 事实上是调用了 sys.stdout.write(obj+'\n')









