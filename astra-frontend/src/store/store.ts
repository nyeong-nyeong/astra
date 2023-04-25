import { reactive } from 'vue';

const storeUser = reactive({
  isLogin: false,
  user: {},
  login(islogin: boolean , userData: {}) {
    this.isLogin = islogin;
    this.user = userData;
  },
});

export default storeUser;