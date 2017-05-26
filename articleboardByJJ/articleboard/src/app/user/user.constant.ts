
import {User} from './user';

export class UserConstant{

  // 로그인했을때 나오는 데이터(node에서) 를 여기에 넣는다. (세션의 역할)
  // 서버에서 데이터를 가져오면 사용자의 데이터를 전부다 집어 넣는다.

  public static user : User = {
    _id : '',
    id : '',
    name : '',
    password : ''
  };

}
