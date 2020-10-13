import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Coaches from '../views/Coaches.vue'
import Lessons from '../views/Lessons.vue'
import CoachSessions from '../views/CoachSessions.vue'
import Statistics from '../views/Statistics.vue'
import Profile from '../views/Profile.vue'
import Lesson from '../views/Lesson.vue'



Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/Home',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/coaches',
    name: 'Coaches',
    component: Coaches
  },
  {
    path: '/lessons',
    name: 'Lessons',
    component: Lessons
  },
  {
    path: '/CoachSessions',
    name: 'CoachSessions',
    component: CoachSessions
  },
  {
    path: '/statistics',
    name: 'Statistics',
    component: Statistics
  },
  {
    path: '/profile',
    name: 'Profile',
    component: Profile
  },
  {
    path: '/lesson',
    name: 'Lesson',
    component: Lesson
  }

  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
