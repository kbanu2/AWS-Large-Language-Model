// This file is generated by omniidl (C++ backend) - omniORB_4_3. Do not edit.

#include "TextProcessing.hh"
#include <omniORB4/IOP_S.h>
#include <omniORB4/IOP_C.h>
#include <omniORB4/callDescriptor.h>
#include <omniORB4/callHandle.h>
#include <omniORB4/objTracker.h>


OMNI_USING_NAMESPACE(omni)

OMNI_MAYBE_UNUSED static const char* _0RL_library_version = omniORB_4_3;



void
TextProcessing::WordFrequency::operator>>= (cdrStream &_n) const
{
  _n.marshalString(word,0);
  frequency >>= _n;

}

void
TextProcessing::WordFrequency::operator<<= (cdrStream &_n)
{
  word = _n.unmarshalString(0);
  (::CORBA::Long&)frequency <<= _n;

}

void
TextProcessing::WordMap::operator>>= (cdrStream &_n) const
{
  _n.marshalString(word,0);
  uid >>= _n;

}

void
TextProcessing::WordMap::operator<<= (cdrStream &_n)
{
  word = _n.unmarshalString(0);
  (::CORBA::Long&)uid <<= _n;

}

void
TextProcessing::ProcessingResult::operator>>= (cdrStream &_n) const
{
  (const WordFrequencyList&) wordFrequencies >>= _n;
  (const WordMapList&) wordMappings >>= _n;
  (const _CORBA_Unbounded_Sequence< DoubleList > &) vectorEmbedding >>= _n;

}

void
TextProcessing::ProcessingResult::operator<<= (cdrStream &_n)
{
  (WordFrequencyList&)wordFrequencies <<= _n;
  (WordMapList&)wordMappings <<= _n;
  (_CORBA_Unbounded_Sequence< DoubleList > &)vectorEmbedding <<= _n;

}

TextProcessing::FileProcessor_ptr TextProcessing::FileProcessor_Helper::_nil() {
  return ::TextProcessing::FileProcessor::_nil();
}

::CORBA::Boolean TextProcessing::FileProcessor_Helper::is_nil(::TextProcessing::FileProcessor_ptr p) {
  return ::CORBA::is_nil(p);

}

void TextProcessing::FileProcessor_Helper::release(::TextProcessing::FileProcessor_ptr p) {
  ::CORBA::release(p);
}

void TextProcessing::FileProcessor_Helper::marshalObjRef(::TextProcessing::FileProcessor_ptr obj, cdrStream& s) {
  ::TextProcessing::FileProcessor::_marshalObjRef(obj, s);
}

TextProcessing::FileProcessor_ptr TextProcessing::FileProcessor_Helper::unmarshalObjRef(cdrStream& s) {
  return ::TextProcessing::FileProcessor::_unmarshalObjRef(s);
}

void TextProcessing::FileProcessor_Helper::duplicate(::TextProcessing::FileProcessor_ptr obj) {
  if (obj && !obj->_NP_is_nil())  omni::duplicateObjRef(obj);
}

TextProcessing::FileProcessor_ptr
TextProcessing::FileProcessor::_duplicate(::TextProcessing::FileProcessor_ptr obj)
{
  if (obj && !obj->_NP_is_nil())  omni::duplicateObjRef(obj);
  return obj;
}

TextProcessing::FileProcessor_ptr
TextProcessing::FileProcessor::_narrow(::CORBA::Object_ptr obj)
{
  if (!obj || obj->_NP_is_nil() || obj->_NP_is_pseudo()) return _nil();
  _ptr_type e = (_ptr_type) obj->_PR_getobj()->_realNarrow(_PD_repoId);
  return e ? e : _nil();
}


TextProcessing::FileProcessor_ptr
TextProcessing::FileProcessor::_unchecked_narrow(::CORBA::Object_ptr obj)
{
  if (!obj || obj->_NP_is_nil() || obj->_NP_is_pseudo()) return _nil();
  _ptr_type e = (_ptr_type) obj->_PR_getobj()->_uncheckedNarrow(_PD_repoId);
  return e ? e : _nil();
}

TextProcessing::FileProcessor_ptr
TextProcessing::FileProcessor::_nil()
{
#ifdef OMNI_UNLOADABLE_STUBS
  static _objref_FileProcessor _the_nil_obj;
  return &_the_nil_obj;
#else
  static _objref_FileProcessor* _the_nil_ptr = 0;
  if (!_the_nil_ptr) {
    omni::nilRefLock().lock();
    if (!_the_nil_ptr) {
      _the_nil_ptr = new _objref_FileProcessor;
      registerNilCorbaObject(_the_nil_ptr);
    }
    omni::nilRefLock().unlock();
  }
  return _the_nil_ptr;
#endif
}

const char* TextProcessing::FileProcessor::_PD_repoId = "IDL:TextProcessing/FileProcessor:1.0";


TextProcessing::_objref_FileProcessor::~_objref_FileProcessor() {
  
}


TextProcessing::_objref_FileProcessor::_objref_FileProcessor(omniIOR* ior, omniIdentity* id) :
   omniObjRef(::TextProcessing::FileProcessor::_PD_repoId, ior, id, 1)
   
   
{
  _PR_setobj(this);
}

void*
TextProcessing::_objref_FileProcessor::_ptrToObjRef(const char* id)
{
  if (id == ::TextProcessing::FileProcessor::_PD_repoId)
    return (::TextProcessing::FileProcessor_ptr) this;
  
  if (id == ::CORBA::Object::_PD_repoId)
    return (::CORBA::Object_ptr) this;

  if (omni::strMatch(id, ::TextProcessing::FileProcessor::_PD_repoId))
    return (::TextProcessing::FileProcessor_ptr) this;
  
  if (omni::strMatch(id, ::CORBA::Object::_PD_repoId))
    return (::CORBA::Object_ptr) this;

  return 0;
}


//
// Code for TextProcessing::FileProcessor::processChunk

// Proxy call descriptor class. Mangled signature:
//  _cTextProcessing_mProcessingResult_i_cstring
class _0RL_cd_c5095f7dec9e70ba_00000000
  : public omniCallDescriptor
{
public:
  inline _0RL_cd_c5095f7dec9e70ba_00000000(LocalCallFn lcfn, const char* op_, size_t oplen, _CORBA_Boolean upcall=0)
    : omniCallDescriptor(lcfn, op_, oplen, 0, _user_exns, 0, upcall)
  {
    
  }
  
  void marshalArguments(cdrStream&);
  void unmarshalArguments(cdrStream&);

  void unmarshalReturnedValues(cdrStream&);
  void marshalReturnedValues(cdrStream&);
  
  
  static const char* const _user_exns[];

  ::CORBA::String_var arg_0_;
  const char* arg_0;
  TextProcessing::ProcessingResult_var result;
};

void _0RL_cd_c5095f7dec9e70ba_00000000::marshalArguments(cdrStream& _n)
{
  _n.marshalString(arg_0,0);

}

void _0RL_cd_c5095f7dec9e70ba_00000000::unmarshalArguments(cdrStream& _n)
{
  arg_0_ = _n.unmarshalString(0);
  arg_0 = arg_0_.in();

}

void _0RL_cd_c5095f7dec9e70ba_00000000::marshalReturnedValues(cdrStream& _n)
{
  (const TextProcessing::ProcessingResult&) result >>= _n;

}

void _0RL_cd_c5095f7dec9e70ba_00000000::unmarshalReturnedValues(cdrStream& _n)
{
  result = new TextProcessing::ProcessingResult;
  (TextProcessing::ProcessingResult&)result <<= _n;

}

const char* const _0RL_cd_c5095f7dec9e70ba_00000000::_user_exns[] = {
  0
};

// Local call call-back function.
static void
_0RL_lcfn_c5095f7dec9e70ba_10000000(omniCallDescriptor* cd, omniServant* svnt)
{
  _0RL_cd_c5095f7dec9e70ba_00000000* tcd = (_0RL_cd_c5095f7dec9e70ba_00000000*)cd;
  TextProcessing::_impl_FileProcessor* impl = (TextProcessing::_impl_FileProcessor*) svnt->_ptrToInterface(TextProcessing::FileProcessor::_PD_repoId);
  tcd->result = impl->processChunk(tcd->arg_0);


}

TextProcessing::ProcessingResult* TextProcessing::_objref_FileProcessor::processChunk(const char* chunkContent)
{
  _0RL_cd_c5095f7dec9e70ba_00000000 _call_desc(_0RL_lcfn_c5095f7dec9e70ba_10000000, "processChunk", 13);
  _call_desc.arg_0 = chunkContent;

  _invoke(_call_desc);
  return _call_desc.result._retn();


}


//
// Code for TextProcessing::FileProcessor::writeResults

// Proxy call descriptor class. Mangled signature:
//  void_i_cTextProcessing_mProcessingResult
class _0RL_cd_c5095f7dec9e70ba_20000000
  : public omniCallDescriptor
{
public:
  inline _0RL_cd_c5095f7dec9e70ba_20000000(LocalCallFn lcfn, const char* op_, size_t oplen, _CORBA_Boolean upcall=0)
    : omniCallDescriptor(lcfn, op_, oplen, 0, _user_exns, 0, upcall)
  {
    
  }
  
  void marshalArguments(cdrStream&);
  void unmarshalArguments(cdrStream&);

    
  
  static const char* const _user_exns[];

  TextProcessing::ProcessingResult_var arg_0_;
  const TextProcessing::ProcessingResult* arg_0;
};

void _0RL_cd_c5095f7dec9e70ba_20000000::marshalArguments(cdrStream& _n)
{
  (const TextProcessing::ProcessingResult&) *arg_0 >>= _n;

}

void _0RL_cd_c5095f7dec9e70ba_20000000::unmarshalArguments(cdrStream& _n)
{
  arg_0_ = new TextProcessing::ProcessingResult;
  (TextProcessing::ProcessingResult&)arg_0_ <<= _n;
  arg_0 = &arg_0_.in();

}

const char* const _0RL_cd_c5095f7dec9e70ba_20000000::_user_exns[] = {
  0
};

// Local call call-back function.
static void
_0RL_lcfn_c5095f7dec9e70ba_30000000(omniCallDescriptor* cd, omniServant* svnt)
{
  _0RL_cd_c5095f7dec9e70ba_20000000* tcd = (_0RL_cd_c5095f7dec9e70ba_20000000*)cd;
  TextProcessing::_impl_FileProcessor* impl = (TextProcessing::_impl_FileProcessor*) svnt->_ptrToInterface(TextProcessing::FileProcessor::_PD_repoId);
  impl->writeResults(*tcd->arg_0);


}

void TextProcessing::_objref_FileProcessor::writeResults(const ::TextProcessing::ProcessingResult& results)
{
  _0RL_cd_c5095f7dec9e70ba_20000000 _call_desc(_0RL_lcfn_c5095f7dec9e70ba_30000000, "writeResults", 13);
  _call_desc.arg_0 = &(::TextProcessing::ProcessingResult&) results;

  _invoke(_call_desc);



}

TextProcessing::_pof_FileProcessor::~_pof_FileProcessor() {}


omniObjRef*
TextProcessing::_pof_FileProcessor::newObjRef(omniIOR* ior, omniIdentity* id)
{
  return new ::TextProcessing::_objref_FileProcessor(ior, id);
}


::CORBA::Boolean
TextProcessing::_pof_FileProcessor::is_a(const char* id) const
{
  if (omni::ptrStrMatch(id, ::TextProcessing::FileProcessor::_PD_repoId))
    return 1;
  
  return 0;
}

const TextProcessing::_pof_FileProcessor _the_pof_TextProcessing_mFileProcessor;

TextProcessing::_impl_FileProcessor::~_impl_FileProcessor() {}


::CORBA::Boolean
TextProcessing::_impl_FileProcessor::_dispatch(omniCallHandle& _handle)
{
  const char* op = _handle.operation_name();

  if (omni::strMatch(op, "processChunk")) {

    _0RL_cd_c5095f7dec9e70ba_00000000 _call_desc(_0RL_lcfn_c5095f7dec9e70ba_10000000, "processChunk", 13, 1);
    
    _handle.upcall(this,_call_desc);
    return 1;
  }

  if (omni::strMatch(op, "writeResults")) {

    _0RL_cd_c5095f7dec9e70ba_20000000 _call_desc(_0RL_lcfn_c5095f7dec9e70ba_30000000, "writeResults", 13, 1);
    
    _handle.upcall(this,_call_desc);
    return 1;
  }


  return 0;
}

void*
TextProcessing::_impl_FileProcessor::_ptrToInterface(const char* id)
{
  if (id == ::TextProcessing::FileProcessor::_PD_repoId)
    return (::TextProcessing::_impl_FileProcessor*) this;
  
  if (id == ::CORBA::Object::_PD_repoId)
    return (void*) 1;

  if (omni::strMatch(id, ::TextProcessing::FileProcessor::_PD_repoId))
    return (::TextProcessing::_impl_FileProcessor*) this;
  
  if (omni::strMatch(id, ::CORBA::Object::_PD_repoId))
    return (void*) 1;
  return 0;
}

const char*
TextProcessing::_impl_FileProcessor::_mostDerivedRepoId()
{
  return ::TextProcessing::FileProcessor::_PD_repoId;
}

TextProcessing::Controller_ptr TextProcessing::Controller_Helper::_nil() {
  return ::TextProcessing::Controller::_nil();
}

::CORBA::Boolean TextProcessing::Controller_Helper::is_nil(::TextProcessing::Controller_ptr p) {
  return ::CORBA::is_nil(p);

}

void TextProcessing::Controller_Helper::release(::TextProcessing::Controller_ptr p) {
  ::CORBA::release(p);
}

void TextProcessing::Controller_Helper::marshalObjRef(::TextProcessing::Controller_ptr obj, cdrStream& s) {
  ::TextProcessing::Controller::_marshalObjRef(obj, s);
}

TextProcessing::Controller_ptr TextProcessing::Controller_Helper::unmarshalObjRef(cdrStream& s) {
  return ::TextProcessing::Controller::_unmarshalObjRef(s);
}

void TextProcessing::Controller_Helper::duplicate(::TextProcessing::Controller_ptr obj) {
  if (obj && !obj->_NP_is_nil())  omni::duplicateObjRef(obj);
}

TextProcessing::Controller_ptr
TextProcessing::Controller::_duplicate(::TextProcessing::Controller_ptr obj)
{
  if (obj && !obj->_NP_is_nil())  omni::duplicateObjRef(obj);
  return obj;
}

TextProcessing::Controller_ptr
TextProcessing::Controller::_narrow(::CORBA::Object_ptr obj)
{
  if (!obj || obj->_NP_is_nil() || obj->_NP_is_pseudo()) return _nil();
  _ptr_type e = (_ptr_type) obj->_PR_getobj()->_realNarrow(_PD_repoId);
  return e ? e : _nil();
}


TextProcessing::Controller_ptr
TextProcessing::Controller::_unchecked_narrow(::CORBA::Object_ptr obj)
{
  if (!obj || obj->_NP_is_nil() || obj->_NP_is_pseudo()) return _nil();
  _ptr_type e = (_ptr_type) obj->_PR_getobj()->_uncheckedNarrow(_PD_repoId);
  return e ? e : _nil();
}

TextProcessing::Controller_ptr
TextProcessing::Controller::_nil()
{
#ifdef OMNI_UNLOADABLE_STUBS
  static _objref_Controller _the_nil_obj;
  return &_the_nil_obj;
#else
  static _objref_Controller* _the_nil_ptr = 0;
  if (!_the_nil_ptr) {
    omni::nilRefLock().lock();
    if (!_the_nil_ptr) {
      _the_nil_ptr = new _objref_Controller;
      registerNilCorbaObject(_the_nil_ptr);
    }
    omni::nilRefLock().unlock();
  }
  return _the_nil_ptr;
#endif
}

const char* TextProcessing::Controller::_PD_repoId = "IDL:TextProcessing/Controller:1.0";


TextProcessing::_objref_Controller::~_objref_Controller() {
  
}


TextProcessing::_objref_Controller::_objref_Controller(omniIOR* ior, omniIdentity* id) :
   omniObjRef(::TextProcessing::Controller::_PD_repoId, ior, id, 1)
   
   
{
  _PR_setobj(this);
}

void*
TextProcessing::_objref_Controller::_ptrToObjRef(const char* id)
{
  if (id == ::TextProcessing::Controller::_PD_repoId)
    return (::TextProcessing::Controller_ptr) this;
  
  if (id == ::CORBA::Object::_PD_repoId)
    return (::CORBA::Object_ptr) this;

  if (omni::strMatch(id, ::TextProcessing::Controller::_PD_repoId))
    return (::TextProcessing::Controller_ptr) this;
  
  if (omni::strMatch(id, ::CORBA::Object::_PD_repoId))
    return (::CORBA::Object_ptr) this;

  return 0;
}


//
// Code for TextProcessing::Controller::startProcessing

// Proxy call descriptor class. Mangled signature:
//  void_i_cstring
class _0RL_cd_c5095f7dec9e70ba_40000000
  : public omniCallDescriptor
{
public:
  inline _0RL_cd_c5095f7dec9e70ba_40000000(LocalCallFn lcfn, const char* op_, size_t oplen, _CORBA_Boolean upcall=0)
    : omniCallDescriptor(lcfn, op_, oplen, 0, _user_exns, 0, upcall)
  {
    
  }
  
  void marshalArguments(cdrStream&);
  void unmarshalArguments(cdrStream&);

    
  
  static const char* const _user_exns[];

  ::CORBA::String_var arg_0_;
  const char* arg_0;
};

void _0RL_cd_c5095f7dec9e70ba_40000000::marshalArguments(cdrStream& _n)
{
  _n.marshalString(arg_0,0);

}

void _0RL_cd_c5095f7dec9e70ba_40000000::unmarshalArguments(cdrStream& _n)
{
  arg_0_ = _n.unmarshalString(0);
  arg_0 = arg_0_.in();

}

const char* const _0RL_cd_c5095f7dec9e70ba_40000000::_user_exns[] = {
  0
};

// Local call call-back function.
static void
_0RL_lcfn_c5095f7dec9e70ba_50000000(omniCallDescriptor* cd, omniServant* svnt)
{
  _0RL_cd_c5095f7dec9e70ba_40000000* tcd = (_0RL_cd_c5095f7dec9e70ba_40000000*)cd;
  TextProcessing::_impl_Controller* impl = (TextProcessing::_impl_Controller*) svnt->_ptrToInterface(TextProcessing::Controller::_PD_repoId);
  impl->startProcessing(tcd->arg_0);


}

void TextProcessing::_objref_Controller::startProcessing(const char* filename)
{
  _0RL_cd_c5095f7dec9e70ba_40000000 _call_desc(_0RL_lcfn_c5095f7dec9e70ba_50000000, "startProcessing", 16);
  _call_desc.arg_0 = filename;

  _invoke(_call_desc);



}


//
// Code for TextProcessing::Controller::finishProcessing

// Proxy call descriptor class. Mangled signature:
//  void
class _0RL_cd_c5095f7dec9e70ba_60000000
  : public omniCallDescriptor
{
public:
  inline _0RL_cd_c5095f7dec9e70ba_60000000(LocalCallFn lcfn, const char* op_, size_t oplen, _CORBA_Boolean upcall=0)
    : omniCallDescriptor(lcfn, op_, oplen, 0, _user_exns, 0, upcall)
  {
    
  }
  
  
    
  
  static const char* const _user_exns[];

  
};

const char* const _0RL_cd_c5095f7dec9e70ba_60000000::_user_exns[] = {
  0
};

// Local call call-back function.
static void
_0RL_lcfn_c5095f7dec9e70ba_70000000(omniCallDescriptor*, omniServant* svnt)
{
  
  TextProcessing::_impl_Controller* impl = (TextProcessing::_impl_Controller*) svnt->_ptrToInterface(TextProcessing::Controller::_PD_repoId);
  impl->finishProcessing();


}

void TextProcessing::_objref_Controller::finishProcessing()
{
  _0RL_cd_c5095f7dec9e70ba_60000000 _call_desc(_0RL_lcfn_c5095f7dec9e70ba_70000000, "finishProcessing", 17);


  _invoke(_call_desc);



}

TextProcessing::_pof_Controller::~_pof_Controller() {}


omniObjRef*
TextProcessing::_pof_Controller::newObjRef(omniIOR* ior, omniIdentity* id)
{
  return new ::TextProcessing::_objref_Controller(ior, id);
}


::CORBA::Boolean
TextProcessing::_pof_Controller::is_a(const char* id) const
{
  if (omni::ptrStrMatch(id, ::TextProcessing::Controller::_PD_repoId))
    return 1;
  
  return 0;
}

const TextProcessing::_pof_Controller _the_pof_TextProcessing_mController;

TextProcessing::_impl_Controller::~_impl_Controller() {}


::CORBA::Boolean
TextProcessing::_impl_Controller::_dispatch(omniCallHandle& _handle)
{
  const char* op = _handle.operation_name();

  if (omni::strMatch(op, "startProcessing")) {

    _0RL_cd_c5095f7dec9e70ba_40000000 _call_desc(_0RL_lcfn_c5095f7dec9e70ba_50000000, "startProcessing", 16, 1);
    
    _handle.upcall(this,_call_desc);
    return 1;
  }

  if (omni::strMatch(op, "finishProcessing")) {

    _0RL_cd_c5095f7dec9e70ba_60000000 _call_desc(_0RL_lcfn_c5095f7dec9e70ba_70000000, "finishProcessing", 17, 1);
    
    _handle.upcall(this,_call_desc);
    return 1;
  }


  return 0;
}

void*
TextProcessing::_impl_Controller::_ptrToInterface(const char* id)
{
  if (id == ::TextProcessing::Controller::_PD_repoId)
    return (::TextProcessing::_impl_Controller*) this;
  
  if (id == ::CORBA::Object::_PD_repoId)
    return (void*) 1;

  if (omni::strMatch(id, ::TextProcessing::Controller::_PD_repoId))
    return (::TextProcessing::_impl_Controller*) this;
  
  if (omni::strMatch(id, ::CORBA::Object::_PD_repoId))
    return (void*) 1;
  return 0;
}

const char*
TextProcessing::_impl_Controller::_mostDerivedRepoId()
{
  return ::TextProcessing::Controller::_PD_repoId;
}

POA_TextProcessing::FileProcessor::~FileProcessor() {}

POA_TextProcessing::Controller::~Controller() {}
