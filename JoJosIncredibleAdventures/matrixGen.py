# 111011
a = input("Starting line: ")
print(a)

for char in range(len(a) - 1):
    a = a[len(a) - 1] + a[0:len(a) - 1] 
    print(a)
