package JavaStudy;


class 해장국 {
    public void 간맞추기(){


        System.out.println("간을 맞춘당");
    }
}


class 뼈해장국 extends 해장국{
    public void 간맞추기(){
        System.out.println("뼈해장국에는 들깨가루가 들어가요");
    }
        }

class 콩나물해장국 extends 해장국{
    public void 간맞추기(){
        System.out.println("콩나물해장국에는 콩나물이 들어가요");
    }
}

class 취객 {
    public void 해장국먹기(해장국 주문요리){
        주문요리.간맞추기();
    }
}


public class Lecture1 {

    public static void main(String[] args){
        취객 취객1 = new 취객();
        해장국 메뉴 = new 해장국();
        뼈해장국 주문 = new 뼈해장국();

        취객1.해장국먹기(메뉴);





    }

}
