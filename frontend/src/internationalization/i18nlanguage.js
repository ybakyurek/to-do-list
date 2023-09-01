import i18n from 'i18next';
import { initReactI18next } from 'react-i18next';

i18n.use(initReactI18next).init({
    resources: {
        en:
        {
            translations: {
                'id': 'ID',
                'task_name': 'Task Name',
                'date': 'Date',
                'update': 'Update',
                'delete': 'Delete',
                'view': 'View',
                'create': 'Add New Task',
                'task_list':"Task List",
                'task_create':"Task Create",
                'task_update':"Task Update",
                'task_delete':"Task Delete",
                'content' : "Content",
                'state' : "State",
                'new_task':"New Task",
                'all' : "All",
                'done': "Done",
                'todo':"ToDo",
                'deleteAll' : "Delete All",
                'deleteDone' : "Delete Done"
            }
        },
        tr:
        {
            translations: {
                'id': 'ID',
                'task_name': 'Görev',
                'date': 'Tarih',
                'update': 'Güncelle',
                'delete': 'Sil',
                'view': 'Göster',
                'create': 'Ekle',
                'task_list':"Görev Listesi",
                'task_create':"Görev Ekle",
                'task_update':"Görev Güncelle",
                'task_delete':"Görev Sil",
                'content' : "İçerik",
                'state' : "Durum",
                'new_task':"Yeni Görev",
                'all' : "Hepsi",
                'done': "Bitenler",
                'todo':"Yapılacaklar",
                'deleteAll' : "Hepsini Sil",
                'deleteDone' : "Bitenleri Sil"
            }
        }
    },
    fallbackLng: 'tr',    //fallbackLng: 'en', fall back function    
    ns: ['translations'], //kelimeleri nerede alsın
    defaultNS: 'translations',
    keySeparator: false,
    interpolation: { escapeValue: false, formatSeparator: ',' },
    react: {
        wait: true
    }
});
export default i18n;