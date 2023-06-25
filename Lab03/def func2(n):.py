def func2(n):
  if(n == 4): 
    return n
  else:
    return 2*func2(n+1)
    
print(func2(1))