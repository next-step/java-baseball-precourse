package baseball;

public class Application {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
	
		int key_num=0;
		int comp_value[]= {0,0,0};
		//입력 숫자
		int inst_num=0;
		
		//100, 10, 1의자리 수 값
		int inst_value[]= {0,0,0};

		//판정값
		
		int strike_count=0;
		int ball_count=0;
		
		for(;;){
			
			key_num=(int)(Math.random()*1000)+1;
			comp_value[0]=key_num/100;
			comp_value[1]=key_num%100/10;
			comp_value[2]=key_num%10;	

					
			while(strike_count<3){
				
				//이건 나중에 지워야 함
				System.out.println("컴퓨터숫자: "+key_num);
				
				
				System.out.println("세자리 숫자를 입력해 주세요 >>");
				inst_num=sc.nextInt();		
				System.out.println("입력숫자: "+inst_num);
				strike_count=0;
				ball_count=0;

				
				inst_value[0]=inst_num/100;inst_value[1]=inst_num%100/10;inst_value[2]=inst_num%10;
				
				for(int i=0;i<3;i++){
					for(int j=0;j<3;j++) {
						if(inst_value[i]==comp_value[i]) {
							strike_count++;							
						}
						
						if(inst_value[i]==comp_value[j] && i!=j) {
						ball_count++;							
						}
					}
				}
				
				if(strike_count==3) {
					System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝~");
					break;
				}
				
				
				if(strike_count==0&&ball_count==0) {
					System.out.println("낫싱");
				}
				
				else {

				System.out.println(strike_count+"스트라이크 ");
				System.out.println(ball_count+"볼");
				
				System.out.println("다시 시도(아무 숫자키 입력)");
                if(sc.nextInt()!='0') continue;
				
				}
			}
			
			if(strike_count==3) {
			System.out.println("게임을 계속하시려면 1을, 종료하시려면 다른 키를 입력해 주세요");
			if(sc.nextInt()==1) continue;
			else {
				System.out.println("Goodbye");
				}break;
			}
		}
    }
}
