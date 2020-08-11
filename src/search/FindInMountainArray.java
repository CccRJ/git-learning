package search;

/**
 * @program: Java_Learning
 * @description: 1095山脉数组中查找目标值
 * @author: ChaiRJ
 * @create: 2020-04-29 10:52
 **/
interface MountainArray{
    public int get(int index);

    public int length();
}
public class FindInMountainArray {
    public int findInMountainArray(int target,MountainArray mountainArr){
        int len=mountainArr.length();
        int l=0,r=len-1,mid;

        while(l<r){
            mid=(l+r)/2;
            int mlv=mountainArr.get(mid-1);
            int mrv=mountainArr.get(mid+1);
            int mv=mountainArr.get(mid);
            System.out.println(mid+" "+mlv+" "+mv+" "+mrv);
            //找到山顶最高值
            if (mlv<mv&&mrv<mv){
                System.out.println(mid);
                if (findTargetInc(target,mountainArr,0,mid)!=-1)
                    return findTargetInc(target,mountainArr,0,mid);
                else if (findTargetDec(target,mountainArr,mid,len-1)!=-1)
                    return findTargetDec(target,mountainArr,mid,len-1);
                else return -1;
            }
            //不能用mid+1防止没有左节点无法找到最高值
            else if (mlv<mv)
                l=mid;
            else
                r=mid;
        }
        return -1;
    }
    //增区间 二分查找
    public int findTargetInc(int target,MountainArray ma,int l,int r){
        while (l<=r){
            int mid=(l+r)/2;

            int mv=ma.get(mid);//中间节点的值mid_value
            System.out.println(mv);
            if (mv==target)
                return mid;
            else if (mv>target)
                r=mid-1;
            else
                l=mid +1;
        }
        return -1;
    }
    //减区间二分查找
    public int findTargetDec(int target,MountainArray ma,int l,int r){
        while (l<=r){
            int mid=(l+r)/2;
            int mv=ma.get(mid);//中间节点的值mid_value
            if (mv==target)
                return mid;
            else if (mv<target)
                r=mid-1;
            else
                l=mid +1;
        }
        return -1;
    }
}
