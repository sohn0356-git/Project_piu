from django.shortcuts import render

# Create your views here.
from django.views.generic import ListView
from bookmarks.models import Bookmark
class BookmarkListView(ListView):
    model = Bookmark

