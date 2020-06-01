import Cookies from 'js-cookie'

const TokenKey = 'Admin-Token'
const UidKey = 'uid'

export function getToken() {
  return Cookies.get(TokenKey)
}

export function setToken(token) {
  return Cookies.set(TokenKey, token)
}

export function setUid(uid) {
  return Cookies.set(UidKey, uid)
}

export function getUid() {
  return Cookies.get(UidKey)
}

export function removeToken() {
  return Cookies.remove(TokenKey)
}
