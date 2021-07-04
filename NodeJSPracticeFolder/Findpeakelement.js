var arr=[1,2,3];
var value=0;
var index=0;
if(arr.length==2)
{
    value= Math.max(arr[0],arr[1]);
    index=arr.findIndex(value);
}
else 
{
for(var i=0;i<arr.length-1;i++)
{
    if((arr[i-1] < arr[i]) && (arr[i] > arr[i+1]) )
    {
        index=i;
    }
    else if ( arr[i+1] > arr[i] && i+1==arr.length-1)
    {
        index=i+1;
        console.log("Index "+index);
    }
}
}
console.log(index);