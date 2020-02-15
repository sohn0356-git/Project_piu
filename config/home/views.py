from django.shortcuts import render

# Create your views here.
from django.shortcuts import render
from django.http import HttpResponse
from django.http import Http404, HttpResponseNotFound
from django.views.generic import ListView


def error(request):
    # return HttpResponseNotFound('<h1>not found</h1>')
    raise Http404("Not Found")

# Create your views here.
def index(request):
    return HttpResponse("Hello, World!")