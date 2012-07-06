﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace HL7.Fhir.Instance.Support
{
    public class XmlUtil
    {
        public const string FHIRNS = "http://hl7.org/fhir";
        public const string IDATTR = "id";
        public const string XHTMLNS = "http://www.w3.org/1999/xhtml";
        public const string DIVELEM = "div";      
    }

    [Serializable]
    public class ResourceXmlParseError : Exception
    {
        public ResourceXmlParseError() { }
        public ResourceXmlParseError(string message) : base(message) { }
        public ResourceXmlParseError(string message, Exception inner) : base(message, inner) { }
        protected ResourceXmlParseError(
          System.Runtime.Serialization.SerializationInfo info,
          System.Runtime.Serialization.StreamingContext context)
            : base(info, context) { }
    }
}