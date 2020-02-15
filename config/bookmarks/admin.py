from django.contrib import admin

# Register your models here.
from django.contrib import admin
from bookmarks.models import Bookmark

class BookmarksAdmin(admin.ModelAdmin):
    list_display = ('title', 'url')


admin.site.register(Bookmark, BookmarksAdmin)

