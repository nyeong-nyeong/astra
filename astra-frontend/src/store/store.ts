import { reactive } from 'vue';

const storeUser = reactive({
  isLogin: false,
  user: {},
  login(islogin: boolean , userData: Object) {
    this.isLogin = islogin;
    this.user = userData;
  },
});

export default storeUser;