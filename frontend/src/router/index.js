import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/pages/Index.vue'
import Mekg from '@/pages/Mekg.vue'
import MedicalNer from '@/pages/MedicalNer.vue'
import MedicalSeg from '@/pages/MedicalSeg.vue'
import MekQa from '@/pages/MekQa.vue'
import Relation from '@/pages/Relation.vue'
import Schemas from '@/pages/Schemas.vue'


const originPush = Router.prototype.push
Router.prototype.push = function push(location){
    return originPush.call(this, location).catch(err => err)
}

Vue.use(Router)

export default new Router({
    mode:"history",
    routes:[

        {
            path: '/',
            name: 'Index',
            component: Index
        },
        {
            path:'/Mekg',
            name: 'Mekg',
            component: Mekg
        },
        {
            path:'/MedicalNer',
            name:'MedicalNer',
            component: MedicalNer
        },
        {
            path:'/MedicalSeg',
            name:'MedicalSeg',
            component: MedicalSeg
        },
        {
            path:'/MekQa',
            name:'MekQa',
            component: MekQa
        },
        {
            path:'/Relation',
            name:'Relation',
            component: Relation
        },
        {
            path:'/Schemas',
            name:'Schemas',
            component: Schemas
        }
        
    ]
})