#include<stdio.h>
#include<string.h>
#include<stdlib.h>
void main()
{
    int a[100];
    int f=0;
    int t,n;
    printf("enter the no:- of test cases:");
    scanf("%d",&t);
    while(t>0)
    {
        f=0;
    printf("enter the size of the array");
    scanf("%d",&n);
    printf("Enter elements ");
    for(int i=0;i<n;i++)
    {
        
    
    scanf("%d",&a[i]);
    }
    
    for(int i=0;i<n;i++)
    {
        for(int j=i+1;j<n;j++)
        {
            int ans=a[i]+a[j];
            for(int k=0;k<n;k++)
            {
            if(ans==a[k])
                f++;
            }
        }
    }
    if(f>0)
    printf("%d",f);
    else
    printf("-1");
    
    t--;
        
}
}
