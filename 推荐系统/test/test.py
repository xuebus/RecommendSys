
import sys

# for l in sys.stdin:
#     d = l.strip().split('\t')
#     print(d)
#

line = "name1	school2	height3	weight4"
line = line.strip()
d = line.split('\t')
name = d.pop(0)
school = d.pop(0)
height = d.pop(0)
weight = d.pop(0)

features = []
features.append("%s=0" % name)
features.append("%s=1" % school)
features.append('%s=2' % height)
features.append('%s=3' % weight)

output = "".join("%s\t" % f for f in features)
print(output)




















